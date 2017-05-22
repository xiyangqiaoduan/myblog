package com.ycb.blog.common.config;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.ycb.blog.common.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-22 11:36
 **/
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private LoginInterceptor interceptor;


     /*@Value("${kaptcha.border}")
    private String kborder;*/

    @Value("${kaptcha.session.key}")
    private String skey;

    @Value("${kaptcha.textproducer.font.color}")
    private String fcolor;

    @Value("${kaptcha.textproducer.font.size}")
    private String fsize;

    @Value("${kaptcha.obscurificator.impl}")
    private String obscurificator;

    @Value("${kaptcha.noise.impl}")
    private String noise;

    @Value("${kaptcha.image.width}")
    private String width;

    @Value("${kaptcha.image.height}")
    private String height;

    @Value("${kaptcha.textproducer.char.length}")
    private String clength;

    @Value("${kaptcha.textproducer.char.space}")
    private String cspace;

    @Value("${kaptcha.background.clear.from}")
    private String from;

    @Value("${kaptcha.background.clear.to}")
    private String to;

    @Value("${kaptcha.textproducer.char.string}")
    private String cstring;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/admin/*");
    }

    /**
     * 验证码
     * @return
     */
    @Bean
    public ServletRegistrationBean codeServlet() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(new KaptchaServlet(), "/admin/login/kaptcha.jpg");
        servlet.addInitParameter("kaptcha.border", "no"/*kborder*/);//无边框
        servlet.addInitParameter("kaptcha.session.key", skey);//session key
        servlet.addInitParameter("kaptcha.textproducer.font.color", fcolor);
        servlet.addInitParameter("kaptcha.textproducer.font.size", fsize);
        servlet.addInitParameter("kaptcha.obscurificator.impl", obscurificator);
        servlet.addInitParameter("kaptcha.noise.impl", noise);
        servlet.addInitParameter("kaptcha.image.width", width);
        servlet.addInitParameter("kaptcha.image.height", height);
        servlet.addInitParameter("kaptcha.textproducer.char.length", clength);
        servlet.addInitParameter("kaptcha.textproducer.char.space", cspace);
        servlet.addInitParameter("kaptcha.background.clear.from", from); //和登录框背景颜色一致
        servlet.addInitParameter("kaptcha.background.clear.to", to);
        servlet.addInitParameter("kaptcha.textproducer.char.string",cstring);//
        return  servlet;

    }


}
