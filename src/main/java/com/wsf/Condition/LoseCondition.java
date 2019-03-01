package com.wsf.Condition;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 7:51
 * @tel:18738322951
 */
public class LoseCondition {

    private String searchType;
    private String searchValue;

    private String bookNo;
    private String stuNo;

    private Integer pageNo;
    private Integer startNo;
    private Integer pageNums = 10;


    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getStartNo() {
        return (pageNo-1)*pageNums;
    }

    public void setStartNo(Integer startNo) {
        this.startNo = startNo;
    }

    public Integer getPageNums() {
        return pageNums;
    }

    public void setPageNums(Integer pageNums) {
        this.pageNums = pageNums;
    }

    @Override
    public String toString() {
        return "LoseCondition{" +
                "searchType='" + searchType + '\'' +
                ", searchValue='" + searchValue + '\'' +
                ", bookNo='" + bookNo + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", pageNo=" + pageNo +
                ", startNo=" + startNo +
                ", pageNums=" + pageNums +
                '}';
    }
}