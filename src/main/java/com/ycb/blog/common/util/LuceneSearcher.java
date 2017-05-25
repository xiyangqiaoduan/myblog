package com.ycb.blog.common.util;

import com.ycb.blog.dto.SearcherDto;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.NIOFSDirectory;
import org.apache.lucene.util.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
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
    private static IndexWriterConfig indexWriterConfig;
    public static Logger LOG = LoggerFactory.getLogger(LuceneSearcher.class);




    public static ReentrantLock lock = new ReentrantLock();
    public void getCurrentLock() throws InterruptedException{
        boolean _lock = lock.tryLock(300, TimeUnit.SECONDS);////如果已经被lock，则立即返回false不会等待，达到忽略操作的效果
        while(!_lock){
            _lock = lock.tryLock(300,TimeUnit.SECONDS);
        }
    }


    static {
        try {
            LOG.debug("init lucene config");
            File indexDir = new File(INDEX_PATH);
            directory = NIOFSDirectory.open(indexDir);
            indexWriterConfig=new IndexWriterConfig(Version.LUCENE_47,new IKAnalyzer());
        } catch (IOException e) {
            LOG.error("init lucene config error", e);
        }

    }

    /**
     * 建立索引
     * @param searcherDto
     * @throws InterruptedException
     */
    public void addBean(SearcherDto searcherDto){
        IndexWriter writer=null;
        try{
            getCurrentLock();
            writer=new IndexWriter(directory,indexWriterConfig);
            Document doc=new Document();
            doc.add(new StringField("sid",searcherDto.getSid(), Field.Store.YES));
            doc.add(new TextField("content", searcherDto.getContent(), Field.Store.YES));
            doc.add(new TextField("title", searcherDto.getTitle(), Field.Store.YES));
            doc.add(new StringField("descrption", searcherDto.getDescription(), Field.Store.YES));
            doc.add(new StringField("url", searcherDto.getUrl(), Field.Store.YES));
            doc.add(new StringField("created", DateTools.dateToString(searcherDto.getCreated(), DateTools.Resolution.YEAR), Field.Store.NO));
            writer.addDocument(doc);
        }catch (Exception e) {
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
     * @param beanId
     */
    public void deleteBean(String beanId){
        IndexWriter writer=null;
        try{
            getCurrentLock();
            writer=new IndexWriter(directory,indexWriterConfig);
            writer.deleteDocuments(new Term(beanId));
        }catch(Exception e){
            LOG.error("delete bean to luncene,beanId:",beanId,e);
        }finally {
            try{
                if(writer==null){
                    writer.close();
                }
            }catch (Exception e){
                LOG.error("close failed", e);
            }
            lock.unlock();
        }
    }

    /**
     * 更新索引消息
     * @param searcherDto
     */
    public void updateBean(SearcherDto searcherDto){
        deleteBean(searcherDto.getSid());
        addBean(searcherDto);
    }

    /**
     * 重建索引
     */
    public static  void reloadIndex(){

    }







    public void search(String keyword,String module){

        try{

            IndexReader indexReader= DirectoryReader.open(directory);
            IndexSearcher searcher=new IndexSearcher(indexReader);



        }catch (Exception e){
            LOG.error("search error：",e);
        }

    }






}
