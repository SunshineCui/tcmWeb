package com.mai.tcm.model;

public class News {

    //状态：-1 已删除，0 未发布，1已发布
    public static final int STATUS_DELETE = -1;

    public static final int STATUS_RELEASED = 1;

    public static final int STATUS_OFFLINE = 2;

    private String newsID;

    private Integer targetType;

    private String targetParameter;

    private String abstracts;

    private Integer status;

    private Long createTime;

    private String createPersonID;

    private String createPersonName;

    private String title;

    private Integer sortNO;

    private String content;

    public News(String newsID, Integer targetType, String targetParameter, String abstracts, Integer status, Long createTime, String createPersonID, String createPersonName, String title, Integer sortNO, String content) {
        this.newsID = newsID;
        this.targetType = targetType;
        this.targetParameter = targetParameter;
        this.abstracts = abstracts;
        this.status = status;
        this.createTime = createTime;
        this.createPersonID = createPersonID;
        this.createPersonName = createPersonName;
        this.title = title;
        this.sortNO = sortNO;
        this.content = content;
    }

    public News() {
        super();
    }

    public String getNewsID() {
        return newsID;
    }

    public void setNewsID(String newsID) {
        this.newsID = newsID == null ? null : newsID.trim();
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

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts == null ? null : abstracts.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}