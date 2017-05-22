package com.ycb.blog.web.controller;

import com.ycb.blog.common.util.base.BaseController;
import com.ycb.blog.enums.ArticlePublisheEnum;
import com.ycb.blog.model.Article;
import com.ycb.blog.model.Tag;
import com.ycb.blog.service.ArticleService;
import com.ycb.blog.service.OptionService;
import com.ycb.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2017-05-09 14:13
 **/
@Controller
public class IndexController extends BaseController {


    @Autowired
    private OptionService optionService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @RequestMapping("/")
    public String index(Model model) {

        //TODO 暂时没有实现
        List<Article> articles = articleService.getAllArticles(new Article(), null, null);
        model.addAttribute("articles", articles);
        Map<String, String> systemMap = optionService.getAllOptions();
        model.addAttribute("systemMap", systemMap);
        List<Tag> tags = tagService.queryAllTags();
        model.addAttribute("tags",tags);
        return "9IPHP/index";
    }

    @RequestMapping("/detail/{path}/{id}.html")
    public String articleDetail(@PathVariable String path, @PathVariable String id, Model model) {
        LOG.debug("请求地址：path={},id={}", path, id);
        articleService.articleViewCount(id);
        Map<String, String> systemMap = optionService.getAllOptions();
        model.addAttribute("systemMap", systemMap);
        Article article = articleService.findByArticleId(id, ArticlePublisheEnum.SUCCESS_PUBLISHE.getCode());
        model.addAttribute("article", article);
        List<Tag> tags = tagService.queryAllTags();
        model.addAttribute("tags",tags);
        return "9IPHP/article";
    }

    @RequestMapping("/tags/{tagTitle}")
    public String tagArticleList(@PathVariable String tagTitle, Model model) {
        Map<String, String> systemMap = optionService.getAllOptions();
        model.addAttribute("systemMap", systemMap);
        Tag tag = tagService.findByTagTitle(tagTitle);
        model.addAttribute("tag", tag);
        List<Tag> tags = tagService.queryAllTags();
        model.addAttribute("tags",tags);
        List<Article> articles = articleService.queryArticleByTag(tag);
        model.addAttribute("articles", articles);
        return "9IPHP/tag-articles";
    }

    @RequestMapping("tags.html")
    public String tags(Model model) {
        Map<String, String> systemMap = optionService.getAllOptions();
        model.addAttribute("systemMap", systemMap);
        List<Tag> tags = tagService.queryAllTags();
        model.addAttribute("tags",tags);
        return "9IPHP/tags";
    }


}
