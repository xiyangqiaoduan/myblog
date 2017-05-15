package com.ycb.blog.service.impl;

import com.ycb.blog.dao.OptionDao;
import com.ycb.blog.model.Option;
import com.ycb.blog.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 站点基础信息管理
 *
 * @author yangcb
 * @create 2017-05-15 23:09
 **/
@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionDao optionDao;


    @Override
    public void insertOrUpdate(List<Option> options) {

        if (options == null && options.isEmpty()) {
            return;
        }

        for (Option option : options) {
            Option val = optionDao.findByKey(option.getOptionKey());
            if (val == null) {
                optionDao.insert(option);
            } else {
                optionDao.update(option);
            }
        }

    }
}
