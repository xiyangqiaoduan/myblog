package com.ycb.blog.common.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author yangcb
 * @create 2017-05-18 18:33
 **/
public class IDUtil {


    /**
     * 根据ip+时间戳 生成唯一序列
     *
     * @return
     */
    public static String getIPID() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        return getIpTimeRand(IPUtil.getIpAddress(request));
    }


    /**
     * 根据twitter生成主键策略
     * @return
     */
    public static  String getID(){
        SnowflakeIdWorker snowflakeIdWorker=new SnowflakeIdWorker(0,0);
        return  String.valueOf( snowflakeIdWorker.nextId());
    }





    private static String getIpTimeRand(String ip) {
        StringBuffer sb = new StringBuffer();
        if (ip != null) {
            String a[] = ip.split("\\.");                //根据点来拆分ip地址，但点要转义
            for (int i = 0; i < a.length; i++) {
                sb.append(addZero(a[i], 3));            //调用补零的方法，每块ip不足三位的自动补足到三位
            }
            sb.append(getTimeStamp());                //用this来调用外部的方法
            Random random = new Random();                        //要产生随机数
            for (int i = 0; i < 3; i++) {                            //产生三位随机数
                sb.append(random.nextInt(10));                //每位随机数都不超过10
            }
        }
        return sb.toString();


    }

    @SuppressWarnings("unused")
    private static String getDate() {                                //关于日期与时间的实现
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SSS");
        return sdf.format(new Date());
    }

    private static String getTimeStamp() {                            //返回时间戳
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhmmssSSS");
        return sdf.format(new Date());
    }

    private static String addZero(String str, int len) {                //自动补零的方法，参数为指定的字符串和长度
        StringBuffer s = new StringBuffer();
        s.append(str);
        while (s.length() < len) {
            s.insert(0, "0");                                //在零的位置上进行补零操作
        }
        return s.toString();
    }


}
