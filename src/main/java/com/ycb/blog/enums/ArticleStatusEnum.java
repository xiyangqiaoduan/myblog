package com.ycb.blog.enums;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-21 12:05
 **/
public enum ArticleStatusEnum {

    DEL(0),NOT_DEL(1);

    private int code;

    ArticleStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
