package com.ycb.blog.service;

import com.ycb.blog.model.User;

/**
 * 用户service
 *
 * @author yangcb
 * @create 2017-05-11 17:19
 **/
public interface UserService {

    /**
     * 根据邮箱获取用户信息
     * @param userEmail
     * @return
     */
    User getByEmail(String userEmail);


}
