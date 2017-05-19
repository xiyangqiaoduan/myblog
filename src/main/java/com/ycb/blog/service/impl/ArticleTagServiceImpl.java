package com.ycb.blog.service.impl;

import com.ycb.blog.dao.ArticleTagDao;
import com.ycb.blog.model.ArticleTag;
import com.ycb.blog.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-19 12:09
 **/
@Service
public class ArticleTagServiceImpl implements ArticleTagService {

    @Autowired
    private ArticleTagDao articleTagDao;

    @Override
    public int insertArticleTag(ArticleTag articleTag) {
        return articleTagDao.insertArticleTag(articleTag);
    }
}
