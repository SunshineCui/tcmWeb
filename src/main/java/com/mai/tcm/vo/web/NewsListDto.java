package com.mai.tcm.vo.web;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/15.
 */
public class NewsListDto {

    private String newsID;

    private String title;

    private Integer sortNO;

    private String jumpURL;

    public String getNewsID() {
        return newsID;
    }

    public void setNewsID(String newsID) {
        this.newsID = newsID;
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
}
