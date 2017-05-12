package com.ycb.blog.dto;

import java.io.Serializable;

/**
 * 封装返回值
 *
 * @author yangcb
 * @create 2017-05-11 16:50
 **/
public class  Result<T> implements Serializable{

    /**
     * 状态
     */
    private boolean status = false;

    /**
     * 错误码
     */
    private int errCode = 0000;

    /**
     * 错误信息
     */
    private String errMsg = "success";

    private String url;

    /**
     * 返回结果实体
     */
    private T resultData;

    public Result() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                ", url='" + url + '\'' +
                ", resultData=" + resultData +
                '}';
    }
}
