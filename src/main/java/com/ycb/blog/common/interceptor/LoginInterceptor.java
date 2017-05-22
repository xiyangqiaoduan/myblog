package com.ycb.blog.common.interceptor;

import com.ycb.blog.common.ICommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台管理登录拦截器
 *
 * @author yangcb
 * @create 2017-05-22 11:49
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private Logger LOG = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        LOG.debug("======================preHandle");
        request.setAttribute("starttime", System.currentTimeMillis());
        Object obj = request.getSession().getAttribute(ICommon.SESSION_ID);
        if (!request.getRequestURI().contains("login")) {
            if (obj == null) {
                //如果当前用户没有登录跳转到登录页面
                response.sendRedirect(request.getContextPath() + "/admin/login.html");
                return false;
            }
        }
        return true;
    }

    /**
     * 请求处理完成
     *
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        LOG.debug("======================postHandle");
        long starttime = (Long) request.getAttribute("starttime");
        request.removeAttribute("starttime");
        long endtime = System.currentTimeMillis();
        LOG.debug("======请求地址 url={}, 处理时间：time= {}", request.getRequestURI(), endtime - starttime);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        LOG.debug("=================afterCompletion==================");
    }


}
