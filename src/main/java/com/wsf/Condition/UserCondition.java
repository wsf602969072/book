package com.wsf.Condition;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 8:10
 * @tel:18738322951
 */
public class UserCondition {

    private String searchType;
    private String searchValue;

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

    //编号
    private Integer userId;
    //用户姓名
    private String  name;
    //权限
    private Integer privilege;

    //页码
    private Integer pageNo;
    //开始的页数
    private Integer startNums;
    private Integer pageNums = 10;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Integer privilege) {
        this.privilege = privilege;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "UserCondition{" +
                "searchType='" + searchType + '\'' +
                ", searchValue='" + searchValue + '\'' +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", privilege=" + privilege +
                ", pageNo=" + pageNo +
                ", startNums=" + startNums +
                ", pageNums=" + pageNums +
                '}';
    }
}
