package com.ycb.blog.service;

import com.ycb.blog.enums.ArticlePublisheEnum;
import com.ycb.blog.model.Article;
import com.ycb.blog.model.Tag;

import java.util.List;

/**
 * 博文管理service
 *
 * @author yangcb
 * @create 2017-05-18 17:35
 **/
public interface ArticleService {

   int insertArticle(Article article);

   /**
    * 查询博文列表
    * @param article
    * @return
    */
   List<Article> getAllArticles(Article article,String start,String end);

   /**
    * 获取博文总数
    * @param article
    * @return
    */
   long getArticleCount(Article article);

   /**
    * 更新博文状态
    * @param article
    * @return
    */
   int updateArticle(Article article);

   /**
    * 删除博文
    * @param id
    */
   int delArticle(String id);

   /**
    * 根据文章id  以及发表状态获取文章详情
    * @param id
    * @param articleIsPublished
    * @return
    */
    Article findByArticleId(String id, int articleIsPublished);
   /**
    * 根据标签查询文章信息
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
}
