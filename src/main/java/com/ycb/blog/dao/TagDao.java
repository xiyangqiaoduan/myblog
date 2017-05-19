package com.ycb.blog.dao;

import com.ycb.blog.model.Tag;

/**
 * TAG 标签 DAO
 * @author yangcb
 * @create 2017-05-19 11:49
 **/
public interface TagDao {
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
