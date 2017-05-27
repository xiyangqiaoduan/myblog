package com.ycb.blog.dao;

import com.ycb.blog.enums.ArticleStatusEnum;
import com.ycb.blog.model.Article;
import com.ycb.blog.model.Tag;
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

    /**
     * 根据文章id  以及发表状态获取文章详情
     * @param id
     * @param articleIsPublished
     * @return
     */
    Article findByArticleId(@Param("id") String id,@Param("articleIsPublished") int articleIsPublished);

    /**
     * 根据标签查询文章列表
     * @param tag
     * @return
     */
    List<Article> queryArticleByTag(Tag tag);

    /**
     * 更新文章浏览数
     * @param id
     * @return
     */
    int articleViewCount(String id);

    /**
     * 根据ID 查询文章
     * @param id
     * @return
     */
    Article findById(String id);


}
