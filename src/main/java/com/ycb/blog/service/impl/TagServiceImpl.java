package com.ycb.blog.service.impl;

import com.ycb.blog.dao.TagDao;
import com.ycb.blog.model.ArticleTag;
import com.ycb.blog.model.Tag;
import com.ycb.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标签service实现
 *
 * @author yangcb
 * @create 2017-05-19 11:28
 **/
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;


    @Override
    public Tag findByTagTitle(String tagTitle) {
        return tagDao.findByTagTitle(tagTitle);
    }

    @Override
    public int insertTag(Tag tag) {
        return tagDao.insertTag(tag);
    }

    @Override
    public int update(Tag tag) {
        return tagDao.update(tag);
    }

    @Override
    public int batchUpdateTag(List<ArticleTag> articleTags) {
        return tagDao.batchUpdateTag(articleTags);
    }
}
