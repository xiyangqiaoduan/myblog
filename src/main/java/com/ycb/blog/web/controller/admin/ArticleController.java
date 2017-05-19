package com.ycb.blog.web.controller.admin;

import com.ycb.blog.common.util.base.BaseController;
import com.ycb.blog.dto.Result;
import com.ycb.blog.model.Article;
import com.ycb.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        }catch (Exception e){
            LOG.error("新增博文失败：",e);
            Result<String> result = new Result<String>();
            result.setStatus(false);
            result.setErrMsg("新建博文失败");
            result.setErrCode(9999);
            return result;
        }




    }


}
