package com.wsf.model;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 2:43
 * @tel:18738322951
 */
public class Page<T> {
    //一页的记录数
    private Integer pageNums;
    //当前页
    private Integer pageNo;
    //总的记录数
    private Integer totalRecord;
    //总页数
    private Integer totalPage;
    //数据
    private List<T> data;

    public Integer getPageNums() {
        return pageNums;
    }

    public void setPageNums(Integer pageNums) {
        this.pageNums = pageNums;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPage() {
        return totalRecord%pageNums==0?totalRecord/pageNums:totalRecord/pageNums+1;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNums=" + pageNums +
                ", pageNo=" + pageNo +
                ", totalRecord=" + totalRecord +
                ", totalPage=" + totalPage +
                ", data=" + data +
                '}';
    }
}
