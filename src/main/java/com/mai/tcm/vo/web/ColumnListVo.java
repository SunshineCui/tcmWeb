package com.mai.tcm.vo.web;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/21.
 */
public class ColumnListVo {

    private String columnID;

    private Integer status;

    private String showCreateTime;

    private String topColumnID;

    private String topColumnTitle;

    public String getTopColumnID() {
        return topColumnID;
    }

    public void setTopColumnID(String topColumnID) {
        this.topColumnID = topColumnID;
    }

    public String getTopColumnTitle() {
        return topColumnTitle;
    }

    public void setTopColumnTitle(String topColumnTitle) {
        this.topColumnTitle = topColumnTitle;
    }

    private Integer targetType;

    private String targetParameter;

    private String title;

    private Integer sortNO;

    public String getColumnID() {
        return columnID;
    }

    public void setColumnID(String columnID) {
        this.columnID = columnID;
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


    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public String getTargetParameter() {
        return targetParameter;
    }

    public void setTargetParameter(String targetParameter) {
        this.targetParameter = targetParameter;
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
