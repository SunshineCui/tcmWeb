package com.mai.tcm.service;


import com.mai.framework.base.BaseException;
import com.mai.framework.base.BaseService;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.model.User;
import com.mai.tcm.vo.web.UserVo;

import java.util.List;

/**
 * 用户 业务 接口
 *
 **/
public interface UserService extends BaseService<User, String> {

    /**
     * 根据用户名查询用户
     * 
     * @param username
     * @return
     */
    User selectByUsername(String username);

    UserVo authenticationVo(UserVo userVo);

    public User getUserByID(String userID) throws BaseException;

    public int addUser(User user) throws BaseException;

    public int updateUser(User user) throws BaseException;

    public int updatePWD(String userID, String newpwd) throws BaseException;

    List<UserVo> selectUserVoByPage(Page<UserVo> page, UserVo userVo);

    UserVo getUserVoByID(String userID);
}
