package com.mai.tcm.model;

import java.io.Serializable;

/**
 * Created by denghao on 16/4/17.
 */
public class BaseVo implements Serializable{
    private static final long serialVersionUID = -6624680162140237758L;

    public static final int SUCCESS_CODE = 1;

    public static final int FAIL_CODE = 0;

    private Integer code;
    private String message;
    private String ext;
    private String treeID;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getTreeID() {
        return treeID;
    }

    public void setTreeID(String treeID) {
        this.treeID = treeID;
    }
}
