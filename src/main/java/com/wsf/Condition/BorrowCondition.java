package com.wsf.Condition;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 8:10
 * @tel:18738322951
 */
public class BorrowCondition {
    //搜索条件
    private String searchType;
    private String searchValue;

    private String bookNo;
    private String bookName;
    private String stuNo;
    private String stuName;
    private Integer islose;

    public Integer getIslose() {
        return islose;
    }

    public void setIslose(Integer islose) {
        this.islose = islose;
    }

    //页码
    private Integer pageNo;
    //开始的页数
    private Integer startNums;
    private Integer pageNums = 10;

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }



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

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getStartNums() {
        return (pageNo-1)*pageNums;
    }

    public void setStartNums(Integer startNums) {
        this.startNums = startNums;
    }

    public Integer getPageNums() {
        return pageNums;
    }

    public void setPageNums(Integer pageNums) {
        this.pageNums = pageNums;
    }


    @Override
    public String toString() {
        return "BorrowCondition{" +
                "searchType='" + searchType + '\'' +
                ", searchValue='" + searchValue + '\'' +
                ", bookNo='" + bookNo + '\'' +
                ", bookName='" + bookName + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", islose=" + islose +
                ", pageNo=" + pageNo +
                ", startNums=" + startNums +
                ", pageNums=" + pageNums +
                '}';
    }
}
