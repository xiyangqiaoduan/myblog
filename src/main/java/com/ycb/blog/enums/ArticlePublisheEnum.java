package com.ycb.blog.enums;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-21 12:08
 **/
public enum ArticlePublisheEnum {

   SUCCESS_PUBLISHE(1),FAIL_PUBLISHE(0);


    private int code;

    ArticlePublisheEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
