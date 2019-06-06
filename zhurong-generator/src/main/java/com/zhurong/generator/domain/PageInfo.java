/**   
 * @Title: PageInfo.java
 * @Package: com.essence.euauth.web.config
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.domain;

import java.util.List;

/**
 * @description: 
 * @author LZG
 * @date 2019/5/15
 */
public class PageInfo<T> {

    //当前页
    private int currentPage;

    //每页的条数
    private int pageSize;

    //搜索内容（模糊查询）。例如：userName=张,position=北京
    private String searchContent;

    //总条数
    private int sumSize;

    //条件（外表关联字段），比如：查询某个组织机构下的用户，corpId=101010
    private String condition;

    //结果集
    private List<T> list;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    public int getSumSize() {
        return sumSize;
    }

    public void setSumSize(int sumSize) {
        this.sumSize = sumSize;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}