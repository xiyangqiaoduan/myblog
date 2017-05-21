package com.ycb.blog.dao;

import com.ycb.blog.model.ArticleTag;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-19 12:13
 **/
public interface ArticleTagDao {

    int insertArticleTag(ArticleTag articleTag);

    /**
     * 查询文章关联的标签ID
     * @param articleId
     * @return
     */
    List<ArticleTag> findByArticleId(String articleId);
}
