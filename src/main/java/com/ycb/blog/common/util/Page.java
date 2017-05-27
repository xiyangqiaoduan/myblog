package com.ycb.blog.common.util;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangcb
 * @create 2017-05-27 10:37
 **/
public class Page<T> implements Serializable {

    /**
     * 分页数据集合
     */
    private List<T> list;
    /**
     * 总记录
     */
    private int totalCount;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 当前页数
     */
    private int currentPage;

    /**
     * 每页记录的条数
     */
    private int numPerPage;


    public Page(List<T> list, int totalCount, int totalPage, int currentPage, int numPerPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.numPerPage = numPerPage;
    }


    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    public Page() {
    }

    @Override
    public String toString() {
        return "Page{" +
                "list=" + list +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", numPerPage=" + numPerPage +
                '}';
    }
}
