package com.ycb.blog.web.controller.admin;

import com.ycb.blog.common.util.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Properties;

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
    public String index() {

        return "admin/index";
    }

    @RequestMapping("welcome.html")
    public String weclome(ModelMap modelMap, HttpServletRequest request) {

//        Map<String, String> map = System.getenv();
//        String userName = map.get("USERNAME");// 获取用户名
//        String computerName = map.get("COMPUTERNAME");// 获取计算机名
//        String userDomain = map.get("USERDOMAIN");// 获取计算机域名
        long maxMemory = Runtime.getRuntime().maxMemory();//JVM可以使用的总内存
        long freeMemory = Runtime.getRuntime().freeMemory();//JVM可以使用的剩余内存
//        int localPort = request.getLocalPort();//获取服务器端口
//        String localAddr = request.getLocalAddr();//获取服务器ip
//        String localName = request.getLocalName();//获取服务器域名


//        Properties props = System.getProperties();
//        String osName = props.getProperty("os.name");//操作系统的名称
//        String osArch = props.getProperty("os.arch");//操作系统的构架
//        String osVersion = props.getProperty("os.version");//操作系统的版本
//        // String javaClassPath=props.getProperty("java.class.path");//Java的类路径
//        String userDir = props.getProperty("user.dir");//当前的路径
//        modelMap.put("userDir", userDir);
//        // modelMap.put("javaClassPath", javaClassPath);
//        modelMap.put("osName", osName);
//        modelMap.put("osArch", osArch);
//        modelMap.put("osVersion", osVersion);


//        modelMap.put("localPort", localPort);
//        modelMap.put("localAddr", localAddr);
//        modelMap.put("localName", localName);
        modelMap.put("maxMemory", maxMemory / (1024 * 1024));
        modelMap.put("freeMemory", freeMemory / (1024 * 1024));
//        modelMap.put("userName", userName);
//        modelMap.put("computerName", computerName);
//        modelMap.put("userDomain", userDomain);

        return "admin/welcome";
    }


}
