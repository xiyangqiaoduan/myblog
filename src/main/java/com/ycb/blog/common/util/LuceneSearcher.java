package com.ycb.blog.common.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.NIOFSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public static Logger LOG = LoggerFactory.getLogger(LuceneSearcher.class);

    public static ReentrantLock lock = new ReentrantLock();

    public void getCurrentLock() throws InterruptedException{
        boolean _lock = lock.tryLock(300, TimeUnit.SECONDS);
        while(!_lock){
            _lock = lock.tryLock(300,TimeUnit.SECONDS);
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


}
