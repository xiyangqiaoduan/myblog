package com.ycb.blog.model;

/**
 * 管理用户
 *
 * @author yangcb
 * @create 2017-05-11 15:42
 **/
public class User
{

    private String id;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户地址
     */
    private String userUrl;
    /**
     * 密码
     */
    private String userPassword;
    /**
     * 角色
     */
    private String userRole;
    /**
     * 文章数
     */
    private int userArticleCount;
    /**
     * 发表的文章数
     */
    private int userPublishedArticleCount;
    /**
     * 头像
     */
    private String userVatar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getUserArticleCount() {
        return userArticleCount;
    }

    public void setUserArticleCount(int userArticleCount) {
        this.userArticleCount = userArticleCount;
    }

    public int getUserPublishedArticleCount() {
        return userPublishedArticleCount;
    }

    public void setUserPublishedArticleCount(int userPublishedArticleCount) {
        this.userPublishedArticleCount = userPublishedArticleCount;
    }

    public String getUserVatar() {
        return userVatar;
    }

    public void setUserVatar(String userVatar) {
        this.userVatar = userVatar;
    }
}
