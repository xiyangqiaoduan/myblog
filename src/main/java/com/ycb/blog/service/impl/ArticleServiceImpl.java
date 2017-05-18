package com.ycb.blog.service.impl;

import com.ycb.blog.dao.ArticleDao;
import com.ycb.blog.model.Article;
import com.ycb.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 博文管理实现
 *
 * @author yangcb
 * @create 2017-05-18 17:36
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public int insertArticle(Article article) {


        articleDao.insert(article);

        return 0;
    }
}
