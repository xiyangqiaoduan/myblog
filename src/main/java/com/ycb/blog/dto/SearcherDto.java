package com.ycb.blog.dto;

import java.util.Date;

/**
 * 建立索引DTO
 *
 * @author yangcb
 * @create 2017-05-24 14:59
 **/
public class SearcherDto {

    private String sid;
    private String title;
    private String description;
    private String content;
    private String url;
    private Date created;
    private Object data; // 保存其他信息，不是用来检索的

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
