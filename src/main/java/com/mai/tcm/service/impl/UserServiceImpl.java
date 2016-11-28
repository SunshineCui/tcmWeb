package com.mai.tcm.service.impl;

import com.mai.framework.base.BaseDao;
import com.mai.framework.base.BaseException;
import com.mai.framework.base.BaseServiceImpl;
import com.mai.framework.feature.mybatis.Page;
import com.mai.tcm.dao.UserMapper;
import com.mai.tcm.model.User;
import com.mai.tcm.model.UserExample;
import com.mai.tcm.service.UserService;
import com.mai.tcm.vo.web.UserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

/**
 * 用户Service实现类
 *
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return insert(user);
    }

    @Override
    public int updateUser(User user) throws BaseException {
        return update(user);
    }

    @Override
    public int updatePWD(String userID, String newpwd) throws BaseException {
        User user = new User();
        user.setUserID(userID);
        user.setPassword(newpwd);
        return updateUser(user);
    }

    @Override
    public List<UserVo> selectUserVoByPage(Page<UserVo> page, UserVo userVo) {
        return userMapper.selectUserVoByPage(page, userVo);
    }

    @Override
    public UserVo getUserVoByID(String userID) {
        return userMapper.getUserVoByID(userID);
    }

    @Override
    public BaseDao<User, String> getDao() {
        return userMapper;
    }

    @Override
    public User selectByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(username);
        List<User> list = userMapper.selectByExample(example);
        if(list!= null && list.size() > 0){
            return list.get(0);
        }else{
            return null;
        }

    }

    @Override
    public UserVo authenticationVo(UserVo userVo) {
        UserVo userVo1 = userMapper.authenticationVo(userVo);
        if(userVo1 != null){
            User user = new User();
            user.setUserID(userVo1.getUserID());
            user.setLoginTime(Calendar.getInstance().getTimeInMillis());
            this.update(user);
        }
        return userVo1;
    }

    @Override
    public User getUserByID(String userID) throws BaseException {
        return selectById(userID);
    }

}
