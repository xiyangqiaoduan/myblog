package com.ycb.blog.web.controller.admin;

import com.ycb.blog.common.util.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-15 13:39
 **/
@Controller
@RequestMapping("admin")
public class SystemBaseController  extends BaseController{

    @RequestMapping(value = "system-base.html",method= RequestMethod.GET)
    public String systemBase(){
        return "admin/system-base";
    }

}
