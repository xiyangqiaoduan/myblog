package com.ycb.blog.web.controller.admin;

import com.ycb.blog.common.ICommon;
import com.ycb.blog.common.util.MD5Util;
import com.ycb.blog.common.util.base.BaseController;
import com.ycb.blog.dto.Result;
import com.ycb.blog.model.User;
import com.ycb.blog.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户登录
 *
 * @author yangcb
 * @create 2017-05-11 15:53
 **/
@Controller
@RequestMapping("admin")
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    @Value("${MD5.salt}")
    private String salt;

    @Value("${kaptcha.session.key}")
    private String session_code;


    @GetMapping("/login.html")
    public String loginPage() {
        return "admin/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST, produces = {JSON_UTF8})
    @ResponseBody
    public Result login(String userEmail, String userPassword, String code, HttpServletRequest request) {

        LOG.debug("request params userEmail={} ,userPassword={} ,code={}",userEmail,userPassword,code);

        Result result = new Result();
        if (StringUtils.isEmpty(code)) {
            result.setErrMsg("验证码不能为空！");
            return result;
        }
        if (StringUtils.isEmpty(userEmail)) {
            result.setErrMsg("邮箱不能为空！");
            return result;
        }
        if (StringUtils.isEmpty((userPassword))) {
            result.setErrMsg("用户密码不能为空");
            return result;
        }
        String code_cache = (String) request.getSession().getAttribute(session_code);
        LOG.debug("code_cache={}",code_cache);

        if(!code.toLowerCase().equals(code_cache.toLowerCase())){
            result.setErrMsg("验证码不正确");
            return result;
        }

        User user = userService.getByEmail(userEmail);
        if (user == null) {
            result.setErrMsg("当前用户信息不存在");
            return result;
        }

        if (!MD5Util.MD5(userPassword).equals(user.getUserPassword())) {
            result.setErrMsg("用户密码错误");
            return result;
        }

        request.getSession().setAttribute(ICommon.SESSION_ID, user);
        result.setStatus(true);
        result.setUrl("/admin/index.html");


        return result;
    }


}
