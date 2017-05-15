package com.ycb.blog.web.controller.admin;

import com.ycb.blog.common.util.base.BaseController;
import com.ycb.blog.dto.Result;
import com.ycb.blog.model.Option;
import com.ycb.blog.service.OptionService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-15 13:39
 **/
@Controller
@RequestMapping("admin")
public class SystemBaseController extends BaseController {

    @Autowired
    private OptionService optionService;

    @RequestMapping(value = "system-base.html", method = RequestMethod.GET)
    public String systemBase() {
        return "admin/system-base";
    }

    @RequestMapping(value = "system-base", method = RequestMethod.POST)
    @ResponseBody
    public Result systemBase(HttpServletRequest request) {

        Result<String> result = new Result<String>();

        Enumeration<String> enumeration = request.getParameterNames();

        List<Option> options = new ArrayList<Option>();

        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String val = request.getParameter(key);
            Option option = new Option();
            option.setOptionKey(key);
            option.setOptionValue(val);
            options.add(option);
        }

        optionService.insertOrUpdate(options);


        return result;

    }

}
