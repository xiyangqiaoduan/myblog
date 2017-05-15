package com.ycb.blog.dao;

import com.ycb.blog.model.Option;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-15 23:20
 **/
public interface OptionDao {
    /**
     * 插入信息
     * @param option
     * @return
     */
    int insert(Option option);

    /**
     * 更新信息
     * @param option
     * @return
     */
    int update(Option option);

    /**
     * 根据key值查询
     * @param key
     * @return
     */
    Option findByKey(String key);

}
