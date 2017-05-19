package com.ycb.blog.model;

/**
 *  标签关联信息
 * @author yangcb
 * @create 2017-05-19 11:40
 **/
public class ArticleTag {

    private String id;
    private String articleId;
    private String tagId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }
}
