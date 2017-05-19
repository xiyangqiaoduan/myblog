package com.ycb.blog.web.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ycb.blog.common.util.base.BaseController;
import com.ycb.blog.dto.Result;
import com.ycb.blog.model.Article;
import com.ycb.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String articleList(@RequestBody String body) {

        LOG.debug("分页请求数据 body={}", body);
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


        // 生成20条测试数据
        List<Map<String,Object>> lst = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < 20; i++) {
            Map<String,Object> map=new HashMap<String,Object>();
           // String[] d = {"co1_data" + i};
            map.put("id","co1_data" + i);
            map.put("articleTitle","SpringBoot Demo0"+i);
            map.put("articleUpdateDate",new Date());
            map.put("articleViewCount",i*new Random(100).nextInt());
            map.put("articleIsPublished",i%2>0?1:0);
            lst.add(map);
        }
        JSONObject getObj = new JSONObject();
        getObj.put("sEcho", sEcho);// 不知道这个值有什么用,有知道的请告知一下
        getObj.put("iTotalRecords", lst.size());//实际的行数
        getObj.put("iTotalDisplayRecords", lst.size());//显示的行数,这个要和上面写的一致
        getObj.put("aaData", lst.subList(iDisplayStart,iDisplayStart + iDisplayLength));//要以JSON格式返回
        return getObj.toString();
    }


    @RequestMapping(value = "article-list.html", method = RequestMethod.GET)
    public String articlePage() {
        return "admin/article-list";
    }

    @RequestMapping(value = "article-add.html", method = RequestMethod.GET)
    public String addArticlePage() {
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


}
