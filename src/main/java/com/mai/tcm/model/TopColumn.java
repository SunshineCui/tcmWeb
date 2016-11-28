package com.mai.tcm.model;

public class TopColumn {

    //状态：-1 已删除，0 未发布，1已发布
    public static final int STATUS_DELETE = -1;

    public static final int STATUS_RELEASED = 1;

    public static final int STATUS_OFFLINE = 2;

    private String topColumnID;

    public String getTopColumnID() {
        return topColumnID;
    }

    public void setTopColumnID(String topColumnID) {
        this.topColumnID = topColumnID;
    }

    private Integer status;

    private Long createTime;

    private String createPersonID;

    private String createPersonName;

    private String title;

    private Integer sortNO;

    public TopColumn(String top_columnID, Integer status, Long createTime, String createPersonID, String createPersonName, String title, Integer sortNO) {
        this.topColumnID = top_columnID;
        this.status = status;
        this.createTime = createTime;
        this.createPersonID = createPersonID;
        this.createPersonName = createPersonName;
        this.title = title;
        this.sortNO = sortNO;
    }

    public TopColumn() {
        super();
    }

    public String getTop_columnID() {
        return topColumnID;
    }

    public void setTop_columnID(String top_columnID) {
        this.topColumnID = top_columnID == null ? null : top_columnID.trim();
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
}