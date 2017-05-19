package com.ycb.blog.service;

import com.ycb.blog.model.Tag;

/**
 * 标签service
 *
 * @author yangcb
 * @create 2017-05-19 11:27
 **/
public interface TagService {

    /**
     * 根据标签名称获取标签
     * @param tagTitle
     * @return
     */
    Tag findByTagTitle(String tagTitle);

    /**
     * 新增标签
     * @param tag
     * @return
     */
    int insertTag(Tag tag);

    /**
     * 更新标签
     * @param tag
     * @return
     */
    int update(Tag tag);
}
