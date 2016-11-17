package com.mai.tcm.vo.web;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/8.
 */
public class CarouselListDto {

    private String carouselID;

    private String title;

    private Integer sortNO;

    private String jumpURL;

    private String picUrl;

    private Integer ctype;

    public String getCarouselID() {
        return carouselID;
    }

    public void setCarouselID(String carouselID) {
        this.carouselID = carouselID;
    }

    public String getJumpURL() {
        return jumpURL;
    }

    public void setJumpURL(String jumpURL) {
        this.jumpURL = jumpURL;
    }

    public Integer getSortNO() {
        return sortNO;
    }

    public void setSortNO(Integer sortNO) {
        this.sortNO = sortNO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }
}
