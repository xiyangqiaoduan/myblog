package com.ycb.blog.web.controller.admin;

import com.ycb.blog.common.util.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-12 16:29
 **/
@Controller
@RequestMapping("admin")
public class ArticleController extends BaseController {


    @RequestMapping(value = "article-list.html",method = RequestMethod.GET)
    public String articlePage(){
        return "admin/article-list";
    }

    @RequestMapping(value = "article-add.html",method = RequestMethod.GET)
    public String addArticlePage(){

        return "admin/article-add";

    }



}
