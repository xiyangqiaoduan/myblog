package com.ycb.blog.service;

import com.ycb.blog.model.Article;

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
}
