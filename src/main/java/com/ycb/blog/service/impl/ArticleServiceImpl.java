package com.ycb.blog.service.impl;

import com.ycb.blog.common.util.IDUtil;
import com.ycb.blog.dao.ArticleDao;
import com.ycb.blog.enums.ArticlePublishe;
import com.ycb.blog.enums.ArticleStatusEnum;
import com.ycb.blog.enums.EditorTypeEnum;
import com.ycb.blog.model.Article;
import com.ycb.blog.model.ArticleTag;
import com.ycb.blog.model.Tag;
import com.ycb.blog.service.ArticleService;
import com.ycb.blog.service.ArticleTagService;
import com.ycb.blog.service.TagService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 博文管理实现
 *
 * @author yangcb
 * @create 2017-05-18 17:36
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    private static final Logger LOG = LoggerFactory.getLogger(ArticleServiceImpl.class);


    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private TagService tagService;

    @Autowired
    private ArticleTagService articleTagService;

    @Override
    @Transactional
    public int insertArticle(Article article) {
        String articleId = IDUtil.getID();
        article.setArticleSignId(IDUtil.getIPID());
        article.setArticleEditorType(EditorTypeEnum.SIMDITOR.getCode());
        article.setId(articleId);
        article.setArticleStatus(ArticleStatusEnum.NOT_DEL.getCode());
        articleDao.insert(article);

        if (!StringUtils.isEmpty(article.getArticleTags())) {
            String[] tagTitles = article.getArticleTags().split(",");

            //TODO 后期提取为批量操作
            for (String tagTitle : tagTitles) {
                Tag tag = tagService.findByTagTitle(tagTitle.trim());
                if (tag == null) {
                    tag = new Tag();
                    tag.setId(IDUtil.getID());
                    tag.setTagTitle(tagTitle);
                    //TODO 目前都是直接发表
                    tag.setTagReferenceCount(1);
                    tag.setTagPublishedRefCount(1);
                    tagService.insertTag(tag);
                } else {
                    //更新tag标签关联的文章数目
                    tagService.update(tag);
                }

                ArticleTag articleTag = new ArticleTag();
                articleTag.setId(IDUtil.getID());
                articleTag.setArticleId(articleId);
                articleTag.setTagId(tag.getId());
                articleTagService.insertArticleTag(articleTag);
            }


        }


        return 0;
    }

    @Override
    public List<Article> getAllArticles(Article article, String start, String end) {

        return articleDao.getAllArticles(article, start, end);
    }

    @Override
    public long getArticleCount(Article article) {
        return articleDao.getArticleCount(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleDao.updateArticle(article);
    }

    @Override
    @Transactional
    public int delArticle(String id) {
        Article article = new Article();
        article.setId(id);
        article.setArticleStatus(ArticleStatusEnum.DEL.getCode());
        article.setArticleIsPublished(ArticlePublishe.FAIL_PUBLISHE.getCode());
        articleDao.updateArticle(article);
        List<ArticleTag> articleTags = articleTagService.findByArticleId(id);

        if(articleTags!=null && !articleTags.isEmpty()){

            tagService.batchUpdateTag(articleTags);

        }

        return 0;
    }
}
