package com.mai.tcm.security;


import com.mai.tcm.service.UserService;
import com.mai.tcm.util.CurrentUser;
import com.mai.tcm.vo.web.UserVo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
* 用户身份验证,授权 Realm 组件
*
**/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

//    @Resource
//    private RoleService roleService;
//
//    @Resource
//    private PermissionService permissionService;

//    /**
//     * 权限检查
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        String username = String.valueOf(principals.getPrimaryPrincipal());
//
////        final User user = userService.selectByUsername(username);
//        UserVo userVo = CurrentUser.getCurrentUser();
//        final List<Role> roleInfos = roleService.selectRolesByUserId(userVo.getUserID());
//        for (Role role : roleInfos) {
//            // 添加角色
//            System.err.println(role);
//            authorizationInfo.addRole(role.getRoleSign());
//            userVo.setRoleName(role.getRoleName());
//            final List<Permission> permissions = permissionService.selectPermissionsByRoleId(role.getRoleID());
//            for (Permission permission : permissions) {
//                // 添加权限
//                System.err.println(permission);
//                authorizationInfo.addStringPermission(permission.getPermissionSign());
//            }
//        }
//        return authorizationInfo;
//    }

    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());
//        String password = new String((char[])((UsernamePasswordToken)(token)).getPassword());
        // 通过数据库进行验证
        UserVo authenticationVo = null;
        try{
            authenticationVo = userService.authenticationVo(new UserVo(username, password));
        }catch (Exception e){
            e.printStackTrace();
        }

        if (authenticationVo == null) {
            throw new AuthenticationException("用户名或密码错误.");
        }
        CurrentUser.setCurrentUser(authenticationVo);
//        setCredentialsMatcher()
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
        return authenticationInfo;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
