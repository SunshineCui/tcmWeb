package com.mai.tcm.vo.web;

import java.io.Serializable;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/8.
 */
public class CarouselListVo implements Serializable{

    private String carouselID;

    private Integer sortNO;

    private Integer targetType;

    private String targetParameter;

    private String showUplineTime;

    private String showCreateTime;

    private Integer status;

    private String showTargetParameter;

    private String title;

    public String getCarouselID() {
        return carouselID;
    }

    public void setCarouselID(String carouselID) {
        this.carouselID = carouselID;
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

    public String getShowUplineTime() {
        return showUplineTime;
    }

    public void setShowUplineTime(String showUplineTime) {
        this.showUplineTime = showUplineTime;
    }

    public String getShowCreateTime() {
        return showCreateTime;
    }

    public void setShowCreateTime(String showCreateTime) {
        this.showCreateTime = showCreateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getShowTargetParameter() {
        return showTargetParameter;
    }

    public void setShowTargetParameter(String showTargetParameter) {
        this.showTargetParameter = showTargetParameter;
    }

}
