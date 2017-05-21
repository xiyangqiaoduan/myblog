package com.ycb.blog.dao;

import com.ycb.blog.enums.ArticleStatusEnum;
import com.ycb.blog.model.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-18 17:42
 **/
public interface ArticleDao {

    int insert(Article article);

    /**
     * 查询博文列表
     *
     * @param article
     * @return
     */
    List<Article> getAllArticles(@Param("article") Article article, @Param("start") String start, @Param("end") String end);

    /**
     * @param article
     * @return
     */
    long getArticleCount(Article article);

    /**
     * 更新博文信息
     * @param article
     * @return
     */
    int updateArticle(Article article);

}
