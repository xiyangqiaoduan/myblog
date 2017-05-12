package com.ycb.blog.web.controller.admin;

import com.ycb.blog.common.util.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-12 16:29
 **/
@Controller
@RequestMapping("admin")
public class ArticleController extends BaseController {


    @RequestMapping("article.html")
    public String articlePage(){

        return "admin-article";
    }



}
