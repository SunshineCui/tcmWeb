package com.mai.tcm.vo.web;

/**
 * Created by denghao on 16/5/27.
 */
public class UserVo {

    public static int SELECT_NAME = 1;
    public static int SELECT_USERNAME = 2;

    private String userID;

    private String personID;

    private String userName;

    private String password;

    private Long createTime;

    private Long updateTime;

    private Integer isValid;

    private Long tokenCreateTime;

    private String token;

    private String salt;

    //联合查询 person的信息
    private String personPhoneNum;
    private String personName;

    //用户访问权限设置
//    private List<Map<String,String>> permissionList;
    //RoleName
    private String RoleName;

    private String roleID;

    public UserVo(){}

    public UserVo(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public UserVo(String userID, String personID, String userName, String password, Long createTime, Long updateTime, Integer isValid, Long tokenCreateTime, String token, String salt, String personName) {
        this.userID = userID;
        this.personID = personID;
        this.userName = userName;
        this.password = password;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isValid = isValid;
        this.tokenCreateTime = tokenCreateTime;
        this.token = token;
        this.salt = salt;
        this.personName = personName;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonPhoneNum() {
        return personPhoneNum;
    }

    public void setPersonPhoneNum(String personPhoneNum) {
        this.personPhoneNum = personPhoneNum;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTokenCreateTime() {
        return tokenCreateTime;
    }

    public void setTokenCreateTime(Long tokenCreateTime) {
        this.tokenCreateTime = tokenCreateTime;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }
}
