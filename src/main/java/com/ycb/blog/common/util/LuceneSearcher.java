package com.ycb.blog.common.util;

import com.alibaba.druid.VERSION;
import com.ycb.blog.dto.SearcherDto;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.NIOFSDirectory;
import org.apache.lucene.util.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lucene 检索
 *
 * @author yangcb
 * @create 2017-05-23 14:37
 **/
public class LuceneSearcher {

    public static String INDEX_PATH = "~/indexes/";
    private static Directory directory;
    private static Analyzer analyzer = null;//分词器
    public static Logger LOG = LoggerFactory.getLogger(LuceneSearcher.class);


    public static ReentrantLock lock = new ReentrantLock();

    public void getCurrentLock() throws InterruptedException {
        boolean _lock = lock.tryLock(300, TimeUnit.SECONDS);////如果已经被lock，则立即返回false不会等待，达到忽略操作的效果
        while (!_lock) {
            _lock = lock.tryLock(300, TimeUnit.SECONDS);
        }
    }


    static {
        try {
            LOG.debug("init lucene config");
            File indexDir = new File(INDEX_PATH);
            directory = NIOFSDirectory.open(indexDir);
        } catch (IOException e) {
            LOG.error("init lucene config error", e);
        }

    }

    /**
     * 建立索引
     *
     * @param searcherDto
     * @throws InterruptedException
     */
    public void addBean(SearcherDto searcherDto) {
        IndexWriter writer = null;
        try {
            getCurrentLock();
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_47, new IKAnalyzer());
            writer = new IndexWriter(directory, indexWriterConfig);
            Document doc = new Document();
            doc.add(new StringField("sid", searcherDto.getSid(), Field.Store.YES));
            doc.add(new TextField("content", searcherDto.getContent(), Field.Store.YES));
            doc.add(new TextField("title", searcherDto.getTitle(), Field.Store.YES));
            doc.add(new StringField("descrption", searcherDto.getDescription(), Field.Store.YES));
            doc.add(new StringField("url", searcherDto.getUrl(), Field.Store.YES));
            doc.add(new StringField("created", DateTools.dateToString(searcherDto.getCreated(), DateTools.Resolution.YEAR), Field.Store.NO));
            writer.addDocument(doc);
        } catch (Exception e) {
            LOG.error("add bean to lucene error", e);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                LOG.error("close failed", e);
            }
            lock.unlock();
        }

    }

    /**
     * 删除索引
     *
     * @param beanId
     */
    public void deleteBean(String beanId) {
        IndexWriter writer = null;
        try {
            getCurrentLock();
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_47, new IKAnalyzer());
            writer = new IndexWriter(directory, indexWriterConfig);
            writer.deleteDocuments(new Term(beanId));
        } catch (Exception e) {
            LOG.error("delete bean to luncene,beanId:", beanId, e);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                LOG.error("close failed", e);
            }
            lock.unlock();
        }
    }

    /**
     * 更新索引消息
     *
     * @param searcherDto
     */
    public void updateBean(SearcherDto searcherDto) {
        deleteBean(searcherDto.getSid());
        addBean(searcherDto);
    }


    public Page<SearcherDto> search(String queryString, int pageNum, int pageSize) {

        try {
            IndexReader indexReader = DirectoryReader.open(directory);
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);
            Query query = getQuery(queryString);
            if (query == null) {
                return null;
            }
            ScoreDoc scoreDoc = getScoreDoc(pageNum, pageSize, query, indexSearcher);
            TopDocs topDocs = indexSearcher.searchAfter(scoreDoc, query, pageSize);
            List<SearcherDto> searcherDtos = getSearcherDtos(indexSearcher, topDocs);
            int totalRow = searchTotalRecord(indexSearcher, query);//总条数
            int totalPages;//总页数
            if ((totalRow % pageSize) == 0) {
                totalPages = totalRow / pageSize;
            } else {
                totalPages = totalRow / pageSize + 1;
            }
            Page<SearcherDto> page = new Page<SearcherDto>(searcherDtos, totalRow, totalPages, pageNum, pageSize);
            return page;
        } catch (Exception e) {
            LOG.error("query error", e);
        }

        return null;
    }

    /**
     * 获取符合条件的总记录数
     *
     * @param indexSearcher
     * @param query
     * @return
     * @throws IOException
     */
    private int searchTotalRecord(IndexSearcher indexSearcher, Query query) throws IOException {
        TopDocs topDocs = indexSearcher.search(query, Integer.MAX_VALUE);
        if (topDocs == null || topDocs.scoreDocs == null || topDocs.scoreDocs.length == 0) {
            return 0;
        }
        ScoreDoc[] docs = topDocs.scoreDocs;
        return docs.length;
    }

    private List<SearcherDto> getSearcherDtos(IndexSearcher indexSearcher, TopDocs topDocs) throws IOException {
        List<SearcherDto> searcherDtos = new ArrayList<SearcherDto>();

        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            Document doc = indexSearcher.doc(scoreDoc.doc);
            SearcherDto searcherDto = new SearcherDto();
            searcherDto.setContent(doc.get("content"));
            searcherDto.setSid(doc.get("sid"));
            searcherDto.setUrl(doc.get("url"));
            searcherDto.setDescription(doc.get("description"));
            searcherDto.setTitle(doc.get("title"));
            searcherDtos.add(searcherDto);
        }
        return searcherDtos;

    }

    /**
     * 根据页码和分页大小获取上一次最后一个ScoreDoc
     *
     * @param pageNum
     * @param pageSize
     * @param query
     * @param indexSearcher
     * @return
     * @throws IOException
     */
    private ScoreDoc getScoreDoc(int pageNum, int pageSize, Query query, IndexSearcher indexSearcher) throws IOException {
        if (pageNum == 1) return null; //第一页返回空
        int num = pageSize * (pageNum - 1);//获取上一页的数量
        TopDocs tds = indexSearcher.search(query, num);
        return tds.scoreDocs[num - 1];
    }

    private Query getQuery(String queryString) {
        try {
            QueryParser queryContentParser = new QueryParser(Version.LUCENE_47, "content", new IKAnalyzer());
            Query queryContent = queryContentParser.parse(queryString);
            QueryParser queryDescriptionParser = new QueryParser(Version.LUCENE_47, "description", new IKAnalyzer());
            Query queryDescription = queryDescriptionParser.parse(queryString);
            QueryParser queryTitleParser = new QueryParser(Version.LUCENE_47, "title", new IKAnalyzer());
            Query queryTitle = queryTitleParser.parse(queryString);

            BooleanQuery booleanClauses = new BooleanQuery();
            booleanClauses.add(new BooleanClause(queryContent, BooleanClause.Occur.SHOULD));
            booleanClauses.add(new BooleanClause(queryDescription, BooleanClause.Occur.SHOULD));
            booleanClauses.add(new BooleanClause(queryTitle, BooleanClause.Occur.SHOULD));

            booleanClauses.setMinimumNumberShouldMatch(1);
            return booleanClauses;
        } catch (Exception e) {
            LOG.error("GET QUERY error:", e);
        }
        return null;

    }

    public Page<SearcherDto> search(String keyword) {
        try {
            IndexReader aIndexReader = DirectoryReader.open(directory);
            IndexSearcher searcher = new IndexSearcher(aIndexReader);
            Query query = getQuery(keyword);
            Sort sort = Sort.RELEVANCE;
            TopDocs topDocs = searcher.search(query, 50, sort);
            List<SearcherDto> searcherBeans = getSearcherDtos(searcher, topDocs);
            Page<SearcherDto> searcherBeanPage = new Page<>(searcherBeans, 1000, 100, 1, 10);
            return searcherBeanPage;
        } catch (Exception e) {
        }
        return null;
    }

}





