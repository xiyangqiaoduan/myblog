package com.ycb.blog.dao;

import com.ycb.blog.model.User;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-11 18:02
 **/
public interface UserDao {

    User getByEmail(String userEmail);

}
