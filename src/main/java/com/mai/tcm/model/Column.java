package com.mai.tcm.model;

public class Column {

    //状态：-1 已删除，0 未发布，1已发布
    public static final int STATUS_DELETE = -1;

    public static final int STATUS_RELEASED = 1;

    public static final int STATUS_OFFLINE = 2;

    private String columnID;

    private Integer status;

    private Long createTime;

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

    private String createPersonID;

    private String createPersonName;

    private String title;

    private Integer sortNO;

    public Column(String columnID, Integer status, Long createTime, String top_columnID, String top_columnTitle, Integer targetType, String targetParameter, String createPersonID, String createPersonName, String title, Integer sortNO) {
        this.columnID = columnID;
        this.status = status;
        this.createTime = createTime;
        this.topColumnID = top_columnID;
        this.topColumnTitle = top_columnTitle;
        this.targetType = targetType;
        this.targetParameter = targetParameter;
        this.createPersonID = createPersonID;
        this.createPersonName = createPersonName;
        this.title = title;
        this.sortNO = sortNO;
    }

    public Column() {
        super();
    }

    public String getColumnID() {
        return columnID;
    }

    public void setColumnID(String columnID) {
        this.columnID = columnID == null ? null : columnID.trim();
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
}