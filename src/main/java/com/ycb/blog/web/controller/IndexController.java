package com.ycb.blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2017-05-09 14:13
 **/
@Controller
public class IndexController {

    @RequestMapping("/")
    public  String index(){
        return "index";
    }

}
