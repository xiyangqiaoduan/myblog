package com.ycb.blog.service.impl;

import com.ycb.blog.dao.UserDao;
import com.ycb.blog.model.User;
import com.ycb.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户service实现类
 *
 * @author yangcb
 * @create 2017-05-11 17:19
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getByEmail(String userEmail) {
        return userDao.getByEmail(userEmail);
    }
}
