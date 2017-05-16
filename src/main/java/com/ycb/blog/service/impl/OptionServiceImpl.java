package com.ycb.blog.service.impl;

import com.ycb.blog.dao.OptionDao;
import com.ycb.blog.model.Option;
import com.ycb.blog.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 站点基础信息管理
 *
 * @author yangcb
 * @create 2017-05-15 23:09
 **/
@Service
public class OptionServiceImpl implements OptionService {

    //这里的单引号不能少，否则会报错，被识别是一个对象
    private static final String CACHE_KEY = "'systembase'";
    private static final String CACHE_NAME = "systembase";


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
                insert(option);
            } else {
                update(option);
            }
        }

    }


    @CacheEvict(value = CACHE_NAME,key = CACHE_KEY)
    public int update(Option option){
        return optionDao.update(option);
    }


    @CacheEvict(value = CACHE_NAME,key = CACHE_KEY)
    public int insert(Option option){
        return optionDao.insert(option);
    }


    @Cacheable(value =CACHE_NAME ,key =CACHE_KEY )
    @Override
    public Map<String, String> getAllOptions() {
        List<Option> options=optionDao.getAllOptions();
        if(options==null ||options.isEmpty()){
            return null;
        }
        Map<String,String> result=new HashMap<String,String>(options.size());
        for(Option option:options){
            result.put(option.getOptionKey(),option.getOptionValue()==null?"":option.getOptionValue());
        }
        return result;
    }
}
