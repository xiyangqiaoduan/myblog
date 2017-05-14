package com.ycb.blog.web.controller.admin;

import com.ycb.blog.common.util.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

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

    @RequestMapping("welcome.html")
    public String weclome(ModelMap modelMap){

        Map<String, String> map=System.getenv();
        String userName = map.get("USERNAME");// 获取用户名
        String computerName = map.get("COMPUTERNAME");// 获取计算机名
        String userDomain = map.get("USERDOMAIN");// 获取计算机域名
        modelMap.put("userName",userName);
        modelMap.put("computerName",computerName);
        modelMap.put("userDomain",userDomain);

        return "admin/welcome";
    }




}
