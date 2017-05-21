package com.ycb.blog.service;

import com.ycb.blog.model.ArticleTag;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-19 12:09
 **/
public interface ArticleTagService {

    int insertArticleTag(ArticleTag articleTag);

    /**
     * 根据文章id查询关联的标签ID
     * @param articleId
     * @return
     */
    List<ArticleTag> findByArticleId(String articleId);
}
