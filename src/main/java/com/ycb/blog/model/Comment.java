package com.ycb.blog.model;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-10 17:31
 **/
public class Comment {

    private String id;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 评论人名称
     */
    private String commentName;
    /**
     * 评论人邮箱
     */
    private String commentEmail;

    /**
     * 文章短码地址
     */
    private String commentSharpURL;

    /**
     * 博客地址
     */
    private String commentURL;

    /**
     * 评论时间
     */
    private Date commentDate;
    /**
     * 评论IP
     */
    private String commentIp;
    /**
     * 评论人头像
     */
    private String commentThumbnailURL;

    /**
     * 对应文章id
     */
    private String commentOnId;
    /**
     * 评论类型
     */
    private String commentOnType;


    private String commentOriginalCommentId;

    private  String commentOriginalCommentName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    public String getCommentEmail() {
        return commentEmail;
    }

    public void setCommentEmail(String commentEmail) {
        this.commentEmail = commentEmail;
    }

    public String getCommentSharpURL() {
        return commentSharpURL;
    }

    public void setCommentSharpURL(String commentSharpURL) {
        this.commentSharpURL = commentSharpURL;
    }

    public String getCommentURL() {
        return commentURL;
    }

    public void setCommentURL(String commentURL) {
        this.commentURL = commentURL;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentIp() {
        return commentIp;
    }

    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp;
    }

    public String getCommentThumbnailURL() {
        return commentThumbnailURL;
    }

    public void setCommentThumbnailURL(String commentThumbnailURL) {
        this.commentThumbnailURL = commentThumbnailURL;
    }

    public String getCommentOnId() {
        return commentOnId;
    }

    public void setCommentOnId(String commentOnId) {
        this.commentOnId = commentOnId;
    }

    public String getCommentOnType() {
        return commentOnType;
    }

    public void setCommentOnType(String commentOnType) {
        this.commentOnType = commentOnType;
    }

    public String getCommentOriginalCommentId() {
        return commentOriginalCommentId;
    }

    public void setCommentOriginalCommentId(String commentOriginalCommentId) {
        this.commentOriginalCommentId = commentOriginalCommentId;
    }

    public String getCommentOriginalCommentName() {
        return commentOriginalCommentName;
    }

    public void setCommentOriginalCommentName(String commentOriginalCommentName) {
        this.commentOriginalCommentName = commentOriginalCommentName;
    }
}
