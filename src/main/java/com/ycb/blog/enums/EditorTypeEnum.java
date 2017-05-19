package com.ycb.blog.enums;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-19 11:00
 **/
public enum  EditorTypeEnum {

    SIMDITOR("simditor");

    private String code;

    private EditorTypeEnum(String code){
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
