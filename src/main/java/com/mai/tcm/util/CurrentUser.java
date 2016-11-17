package com.mai.tcm.util;

import com.mai.tcm.vo.web.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;


public class CurrentUser {
	public static final void setCurrentUser(UserVo userVo) {

		Subject currentUser = SecurityUtils.getSubject();

		if (null != currentUser) {

			Session session = currentUser.getSession();

			if (null != session) {
				session.setAttribute("userInfo", userVo);
			}
		}
	}

	public static final UserVo getCurrentUser() {
		UserVo userVo = null;
		Subject currentUser = SecurityUtils.getSubject();

		if (null != currentUser) {

			Session session = currentUser.getSession();

			if (null != session) {
				userVo = (UserVo) session.getAttribute("userInfo");
			}
		}
		return userVo;
	}

	public static final String getCurrentUserId() {
		UserVo userVo = getCurrentUser();
		if (userVo != null)
			return userVo.getUserID();
		return null;
	}

	public static final Boolean hasRole(String rolename){
		Subject currentUser = SecurityUtils.getSubject();
		return currentUser.hasRole(rolename);
	}

	public static final String getCurrentPersonId() {
		UserVo userVo = getCurrentUser();
		if (userVo != null)
			return userVo.getPersonID();
		return null;
	}

	public static final String getPersonName() {
		UserVo userVo = getCurrentUser();
		if (userVo != null)
			return userVo.getPersonName();
		return null;
	}

	public static final String getPassWord(){
		UserVo userVo = getCurrentUser();
		if (userVo != null)
			return userVo.getPassword();
		return null;
	}

	public static final String getRoleName(){
		UserVo userVo = getCurrentUser();
		if (userVo != null)
			return userVo.getRoleName();
		return null;
	}

	public static final String getUserName(){
		UserVo userVo = getCurrentUser();
		if (userVo != null)
			return userVo.getUserName();
		return null;
	}

	public static final boolean hasAnyRoles(String[] rolenames){
		boolean isRole = false;
		Subject currentUser = SecurityUtils.getSubject();
		for(String rolename:rolenames){
			if(currentUser.hasRole(rolename)){
				isRole = true;
				break;
			}
		}
		return isRole;
	}

	public static final void logOut(){
		Subject subject = SecurityUtils.getSubject();
		if (subject != null){
			subject.logout();
			setCurrentUser(null);
		}
	}
}
