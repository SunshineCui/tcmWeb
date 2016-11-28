package com.mai.tcm.vo.web;

import java.util.List;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/21.
 */
public class TopColumnListVo {

    private String topColumnID;

    private Integer status;

    private String showCreateTime;

    private String title;

    private Integer sortNO;


    public String getTopColumnID() {
        return topColumnID;
    }

    public void setTopColumnID(String topColumnID) {
        this.topColumnID = topColumnID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getShowCreateTime() {
        return showCreateTime;
    }

    public void setShowCreateTime(String showCreateTime) {
        this.showCreateTime = showCreateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSortNO() {
        return sortNO;
    }

    public void setSortNO(Integer sortNO) {
        this.sortNO = sortNO;
    }
}
