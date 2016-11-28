package com.mai.tcm.vo.web;

import java.util.List;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/21.
 */
public class TopColumnListDto {

    private String topColumnID;

    private String title;

    private Integer sortNO;

    //二级栏目list
    private List<ColumnListDto> columnListVoList;

    public List<ColumnListDto> getColumnListVoList() {
        return columnListVoList;
    }

    public void setColumnListVoList(List<ColumnListDto> columnListVoList) {
        this.columnListVoList = columnListVoList;
    }

    public String getTopColumnID() {
        return topColumnID;
    }

    public void setTopColumnID(String topColumnID) {
        this.topColumnID = topColumnID;
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
