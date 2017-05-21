package com.ycb.blog.model;

import java.util.Date;

/**
 * 文章实体
 *
 * @author yangcb
 * @create 2017-05-10 15:07
 **/
public class Article {

    private String id;
    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章描述
     */
    private String articleAbstract;

    /**
     * 文章关键词
     */
    private String articleKeywords;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 创建日期
     */
    private Date articleCreateDate;
    /**
     * 更新日期
     */
    private Date articleUpdateDate;
    /**
     * 文章标签
     */
    private String articleTags;

    /**
     * 文章评论数
     */
    private int articleCommentCount;
    /**
     * 文章访问数
     */
    private int articleViewCount;

    /**
     * 文章标识
     */
    private String articleSignId;

    /**
     * 文章连接
     */
    private String articlePermalink;

    /***
     * 文章是否置顶
     */
    private int articlePutTop;

    /**
     * 是否已发表
     */
    private int articleIsPublished;
    /**
     * 以前是否发表
     */
    private int articleHadBeenPublished;

    /**
     * 随机数
     */
    private double articleRandomDouble;

    /**
     * 是否开启评论
     */
    private int articleCommentable;

    /**
     * 访问密码
     */
    private String articleViewPwd;
    /**
     * 文章编辑类型
     */
    private String articleEditorType;

    /**
     * 作者email
     */
    private String articleAuthorEmail;
    /**
     * 文章状态 0-删除 1-未删除
     */
    private int articleStatus;


    public Article() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleCreateDate() {
        return articleCreateDate;
    }

    public void setArticleCreateDate(Date articleCreateDate) {
        this.articleCreateDate = articleCreateDate;
    }

    public Date getArticleUpdateDate() {
        return articleUpdateDate;
    }

    public void setArticleUpdateDate(Date articleUpdateDate) {
        this.articleUpdateDate = articleUpdateDate;
    }

    public String getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(String articleTags) {
        this.articleTags = articleTags;
    }

    public int getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(int articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    public int getArticleViewCount() {
        return articleViewCount;
    }

    public void setArticleViewCount(int articleViewCount) {
        this.articleViewCount = articleViewCount;
    }

    public String getArticleSignId() {
        return articleSignId;
    }

    public void setArticleSignId(String articleSignId) {
        this.articleSignId = articleSignId;
    }

    public String getArticlePermalink() {
        return articlePermalink;
    }

    public void setArticlePermalink(String articlePermalink) {
        this.articlePermalink = articlePermalink;
    }

    public int getArticlePutTop() {
        return articlePutTop;
    }

    public void setArticlePutTop(int articlePutTop) {
        this.articlePutTop = articlePutTop;
    }

    public int getArticleIsPublished() {
        return articleIsPublished;
    }

    public void setArticleIsPublished(int articleIsPublished) {
        this.articleIsPublished = articleIsPublished;
    }

    public int getArticleHadBeenPublished() {
        return articleHadBeenPublished;
    }

    public void setArticleHadBeenPublished(int articleHadBeenPublished) {
        this.articleHadBeenPublished = articleHadBeenPublished;
    }

    public double getArticleRandomDouble() {
        return articleRandomDouble;
    }

    public void setArticleRandomDouble(double articleRandomDouble) {
        this.articleRandomDouble = articleRandomDouble;
    }

    public int getArticleCommentable() {
        return articleCommentable;
    }

    public void setArticleCommentable(int articleCommentable) {
        this.articleCommentable = articleCommentable;
    }

    public String getArticleViewPwd() {
        return articleViewPwd;
    }

    public void setArticleViewPwd(String articleViewPwd) {
        this.articleViewPwd = articleViewPwd;
    }

    public String getArticleEditorType() {
        return articleEditorType;
    }

    public void setArticleEditorType(String articleEditorType) {
        this.articleEditorType = articleEditorType;
    }

    public String getArticleAuthorEmail() {
        return articleAuthorEmail;
    }

    public void setArticleAuthorEmail(String articleAuthorEmail) {
        this.articleAuthorEmail = articleAuthorEmail;
    }

    public String getArticleKeywords() {
        return articleKeywords;
    }

    public void setArticleKeywords(String articleKeywords) {
        this.articleKeywords = articleKeywords;
    }

    public int getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(int articleStatus) {
        this.articleStatus = articleStatus;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleAbstract='" + articleAbstract + '\'' +
                ", articleKeywords='" + articleKeywords + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleCreateDate=" + articleCreateDate +
                ", articleUpdateDate=" + articleUpdateDate +
                ", articleTags='" + articleTags + '\'' +
                ", articleCommentCount=" + articleCommentCount +
                ", articleViewCount=" + articleViewCount +
                ", articleSignId='" + articleSignId + '\'' +
                ", articlePermalink='" + articlePermalink + '\'' +
                ", articlePutTop=" + articlePutTop +
                ", articleIsPublished=" + articleIsPublished +
                ", articleHadBeenPublished=" + articleHadBeenPublished +
                ", articleRandomDouble=" + articleRandomDouble +
                ", articleCommentable=" + articleCommentable +
                ", articleViewPwd='" + articleViewPwd + '\'' +
                ", articleEditorType='" + articleEditorType + '\'' +
                ", articleAuthorEmail='" + articleAuthorEmail + '\'' +
                '}';
    }
}
