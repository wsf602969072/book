package com.wsf.Condition;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 7:51
 * @tel:18738322951
 */
public class BookCondition {

    private String searchType;
    private String searchValue;

    private String bookNo;
    private String bookName;
    private String bookAuthor;
    private String cataName;
    private Integer bookStatus;

    private Integer pageNo;
    private Integer startNo;
    private Integer pageNums = 10;


    public String getCataName() {
        return cataName;
    }

    public void setCataName(String cataName) {
        this.cataName = cataName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
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

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }



    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }



    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public String toString() {
        return "BookCondition{" +
                "searchType='" + searchType + '\'' +
                ", searchValue='" + searchValue + '\'' +
                ", bookNo='" + bookNo + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", cataName='" + cataName + '\'' +
                ", bookStatus=" + bookStatus +
                ", pageNo=" + pageNo +
                ", startNo=" + startNo +
                ", pageNums=" + pageNums +
                '}';
    }
}