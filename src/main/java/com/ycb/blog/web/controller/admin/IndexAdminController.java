package com.ycb.blog.web.controller.admin;

import com.ycb.blog.common.util.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-12 13:39
 **/
@Controller
@RequestMapping("admin")
public class IndexAdminController extends BaseController {

    @RequestMapping("index.html")
    public String index(){

        return "admin/index";
    }




}
