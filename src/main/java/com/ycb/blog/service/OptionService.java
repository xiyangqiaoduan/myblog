package com.ycb.blog.service;

import com.ycb.blog.model.Option;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-15 23:09
 **/
public interface OptionService {
    /**
     * 更新或插入基本信息
     * @param options
     */
    void insertOrUpdate(List<Option> options);


}
