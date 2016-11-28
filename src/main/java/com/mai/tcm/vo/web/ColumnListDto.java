package com.mai.tcm.vo.web;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/15.
 */
public class ColumnListDto {

    private String columnID;

    private String title;

    private Integer sortNO;

    private String jumpURL;

    private String topColumnID;

    public String getColumnID() {
        return columnID;
    }

    public void setColumnID(String columnID) {
        this.columnID = columnID;
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

    public String getJumpURL() {
        return jumpURL;
    }

    public void setJumpURL(String jumpURL) {
        this.jumpURL = jumpURL;
    }

    public String getTopColumnID() {
        return topColumnID;
    }

    public void setTopColumnID(String topColumnID) {
        this.topColumnID = topColumnID;
    }
}
