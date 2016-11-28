package com.mai.tcm.controller;


import com.mai.framework.base.BaseException;
import com.mai.framework.util.MD5Util;
import com.mai.framework.util.StringUtils;
import com.mai.tcm.model.User;
import com.mai.tcm.security.PermissionSign;
import com.mai.tcm.security.RoleSign;
import com.mai.tcm.service.UserService;
import com.mai.tcm.util.CurrentUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


/**
 * 用户控制器
 *
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "/main";
    }

    @RequestMapping("/updatePwd")
    public String updatePwd(){
        return "/ajax/user/updatepwd";
    }

    @RequestMapping(value = "/updatePassW")
    @ResponseBody
    public Integer updateNewPassWord(String oldpass,String newpass) {
        try {
            if(MD5Util.md5(oldpass).equals(CurrentUser.getPassWord())){
                    userService.updatePWD(CurrentUser.getCurrentUserId(), MD5Util.md5(newpass));
                return 1;
            }else{
                return 0;
            }
        } catch (BaseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 用户登录
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(@Valid User user, Model model, HttpServletRequest request) {

        Subject subject = SecurityUtils.getSubject();

        try {
            // 已登陆则 跳到首页
            if (subject.isAuthenticated()) {
                if(subject.hasRole(RoleSign.ADMIN)){
                    return "redirect:/w/user/index";
                }
            }
            String vcode = request.getParameter("vcode");
            if(StringUtils.isBlank(vcode) || !vcode.equals(request.getSession().getAttribute("verifyCode"))){
                model.addAttribute("loginerror","验证码错误！");
                return "login";
            }

            if(StringUtils.isBlank(user.getUserName())){
                CurrentUser.logOut();
                model.addAttribute("loginerror","用户名不能为空！");
//                return "admin/logIn";
                return "login";
            }
            // 身份验证
            subject.login(new UsernamePasswordToken(user.getUserName(), MD5Util.md5(user.getPassword())));
            // 验证成功在Session中保存用户信息
        } catch (AuthenticationException e) {
            // 身份验证失败
            model.addAttribute("loginerror", "用户名或密码错误 ！");
            return "login";
        }
        if (subject.isAuthenticated()) {// 还没理解怎么设置权限
//            if(subject.hasRole(RoleSign.ADMIN)){
                return "redirect:/w/user/index";
//            }else{
//                return "login";
//            }
        }else{
            return "redirect:/";
        }

    }

    /**
     * 用户登出
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
//        session.removeAttribute("userInfo");
        CurrentUser.logOut();
        // 登出操作
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
        return "login";
    }

    /**
     * 基于角色 标识的权限控制案例
     */
    @RequestMapping(value = "/admin")
    @ResponseBody
    @RequiresRoles(value = RoleSign.ADMIN)
    public String admin() {
        return "拥有admin角色,能访问";
    }

    /**
     * 基于权限标识的权限控制案例
     */
    @RequestMapping(value = "/create")
    @ResponseBody
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public String create() {
        return "拥有user:create权限,能访问";
    }
}
