package com.ycb.blog.web.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycb.blog.common.util.base.BaseController;
import com.ycb.blog.dto.Result;
import com.ycb.blog.enums.ArticleStatusEnum;
import com.ycb.blog.model.Article;
import com.ycb.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-12 16:29
 **/
@Controller
@RequestMapping("admin")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;
    @RequestMapping(value = "article-list", method = RequestMethod.POST)
    @ResponseBody
    public String articleList(@RequestBody String body, Article article,String start,String end, ModelMap modelMap) {
        LOG.debug("分页请求数据 body={}", body);
        LOG.debug("传递参数为article = {}, start = {},end={}",article,start,end);
        JSONArray jsonarray = JSON.parseArray(body);
        String sEcho = null;
        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 0; // 每页显示的行数

        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();
            if (obj.get("name").equals("iDisplayStart"))
                iDisplayStart = obj.getIntValue("value");
            if (obj.get("name").equals("iDisplayLength"))
                iDisplayLength = obj.getIntValue("value");
        }

        PageHelper.startPage(iDisplayStart,iDisplayLength);
        List<Article> list=articleService.getAllArticles(article,start,end);
        PageInfo<Article> pageInfo=new PageInfo<Article>(list);
        LOG.debug("分页测试pageinfo ={}",pageInfo.toString());

        JSONObject getObj = new JSONObject();
        getObj.put("sEcho", sEcho);// 不知道这个值有什么用,有知道的请告知一下
        getObj.put("iTotalRecords", pageInfo.getTotal());//实际的行数
        getObj.put("iTotalDisplayRecords", pageInfo.getTotal());//显示的行数,这个要和上面写的一致
        getObj.put("aaData", pageInfo.getList());//要以JSON格式返回
        return getObj.toString();
    }


    @RequestMapping(value = "article-list.html", method = RequestMethod.GET)
    public String articlePage() {
        return "admin/article-list";
    }

    @RequestMapping(value = "article-add.html", method = RequestMethod.GET)
    public String addArticlePage(Article article,Model model) {
        long count=articleService.getArticleCount(article);
        model.addAttribute("count",count);
        return "admin/article-add";
    }

    @RequestMapping(value = "article-add", method = RequestMethod.GET)
    @ResponseBody
    public Result<String> addArticle(Article article) {
        LOG.debug("新增博文，article {}", article.toString());
        try {

            articleService.insertArticle(article);
            Result<String> result = new Result<String>();
            result.setStatus(true);
            result.setErrMsg("新建博文成功");
            result.setErrCode(0000);
            return result;
        } catch (Exception e) {
            LOG.error("新增博文失败：", e);
            Result<String> result = new Result<String>();
            result.setStatus(false);
            result.setErrMsg("新建博文失败");
            result.setErrCode(9999);
            return result;
        }


    }

    @RequestMapping("article/changeArticleStatus/{articleIsPublished}/{id}")
    @ResponseBody
    public Result<String> changeArticleStatus(@PathVariable int articleIsPublished,@PathVariable String id){
        LOG.debug("request params: articleIsPublished ={},id={}",articleIsPublished,id);
        Article article=new Article();
        article.setArticleIsPublished(articleIsPublished);
        article.setId(id);
        article.setArticleStatus(ArticleStatusEnum.NOT_DEL.getCode());
        articleService.updateArticle(article);
        Result<String> result = new Result<String>();
        result.setStatus(true);
        result.setErrCode(0000);
        result.setErrMsg("success");
        return  result;

    }

    @RequestMapping("article/delArticle/{id}")
    @ResponseBody
    public Result<String> delArticle(@PathVariable String id){
        LOG.debug("request params: id={}",id);

        articleService.delArticle(id);
        Result<String> result = new Result<String>();
        result.setStatus(true);
        result.setErrCode(0000);
        result.setErrMsg("success");
        return  result;

    }



}
