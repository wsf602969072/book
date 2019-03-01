package com.wsf.Condition;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 2:08
 * @tel:18738322951
 */
public class StudentCondition {

    private String searchType;
    private String searchValue;

    private String stuNo;
    private String stuName;
    private String deptName;
    private String specName;

    private Integer pageNo;
    private Integer startNo;
    private Integer pageNums=10;

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

    public String getstuNo() {
        return stuNo;
    }

    public void setstuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
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
}
