package com.mai.tcm.dao;

import com.mai.framework.base.BaseDao;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.model.TopColumn;
import com.mai.tcm.model.User;
import com.mai.tcm.model.UserExample;
import java.util.List;

import com.mai.tcm.vo.web.UserVo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseDao<User, String> {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userID);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userID);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 用户登录验证查询
     *
     * @param record
     * @return
     */
    User authentication(@Param("record") User record);

    /**
     * 分页条件查询
     *
     * @param page
     * @param example
     * @return
     */
    List<User> selectByExampleAndPage(Page<User> page, UserExample example);

    /**
     * 用户登录验证查询
     *
     * @param record
     * @return
     */
    UserVo authenticationVo(@Param("record") UserVo record);

    List<UserVo> selectUserVoByPage(Page<UserVo> page, UserVo userVo);

    UserVo getUserVoByID(String userID);
}