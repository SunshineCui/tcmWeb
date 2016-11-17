package com.mai.tcm.model;

public class Carousel {

    //状态：-1 已删除，0 未发布，1已发布
    public static final int STATUS_DELETE = -1;

    public static final int STATUS_RELEASED = 1;

    public static final int STATUS_OFFLINE = 2;

    //4 targetParameterURL调转，1 考试跳转,2测评跳转, 5是JS调用
    public static final int TARGET_TYPE_URL = 4;

    public static final int TARGET_TYPE_EXAM = 1;

    public static final int TARGET_TYPE_EVA = 2;

    public static final int TARGET_TYPE_SCRIPT = 5;

    private String carouselID;

    private String picUrl;

    private Integer targetType;

    private String targetParameter;

    private Integer status;

    private Long createTime;

    private String createPersonID;

    private String createPersonName;

    private Long uplineTime;

    private String title;

    private Integer sortNO;

    public Carousel(String carouselID, String picUrl, Integer targetType, String targetParameter, Integer status, Long createTime, String createPersonID, String createPersonName, Long uplineTime, String title, Integer sortNO) {
        this.carouselID = carouselID;
        this.picUrl = picUrl;
        this.targetType = targetType;
        this.targetParameter = targetParameter;
        this.status = status;
        this.createTime = createTime;
        this.createPersonID = createPersonID;
        this.createPersonName = createPersonName;
        this.uplineTime = uplineTime;
        this.title = title;
        this.sortNO = sortNO;
    }

    public Carousel() {
        super();
    }

    public String getCarouselID() {
        return carouselID;
    }

    public void setCarouselID(String carouselID) {
        this.carouselID = carouselID == null ? null : carouselID.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
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
        this.targetParameter = targetParameter == null ? null : targetParameter.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCreatePersonID() {
        return createPersonID;
    }

    public void setCreatePersonID(String createPersonID) {
        this.createPersonID = createPersonID == null ? null : createPersonID.trim();
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName == null ? null : createPersonName.trim();
    }

    public Long getUplineTime() {
        return uplineTime;
    }

    public void setUplineTime(Long uplineTime) {
        this.uplineTime = uplineTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getSortNO() {
        return sortNO;
    }

    public void setSortNO(Integer sortNO) {
        this.sortNO = sortNO;
    }
}