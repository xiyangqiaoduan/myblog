package com.ycb.blog.model;

/**
 * 标签
 *
 * @author yangcb
 * @create 2017-05-11 10:03
 **/
public class Tag {

    private String id;
    /**
     * 标签名称
     */
    private String tagTitle;
    /**
     * 标签关联的个数
     */
    private int tagReferenceCount;

    /**
     * 标签关联的文章数
     */
    private int tagPublishedRefCount;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagTitle() {
        return tagTitle;
    }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    public int getTagReferenceCount() {
        return tagReferenceCount;
    }

    public void setTagReferenceCount(int tagReferenceCount) {
        this.tagReferenceCount = tagReferenceCount;
    }

    public int getTagPublishedRefCount() {
        return tagPublishedRefCount;
    }

    public void setTagPublishedRefCount(int tagPublishedRefCount) {
        this.tagPublishedRefCount = tagPublishedRefCount;
    }
}
