package com.mai.tcm.filter;

import com.mai.tcm.vo.web.UserVo;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by denghao on 16/4/8.
 */
public class KickoutSessionControlFilter extends AccessControlFilter {
    private String kickoutUrl; //踢出后到的地址

    public void setKickoutUrl(String kickoutUrl) {
        this.kickoutUrl = kickoutUrl;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        if(!subject.isAuthenticated() && !subject.isRemembered()) {
            //如果没有登录，直接进行之后的流程
            return true;
        }

        Session session = subject.getSession();
        UserVo userVo = null;
        if (null != session) {
            userVo = (UserVo) session.getAttribute("userInfo");
        }

        if (userVo == null) {
            try {
                subject.logout();
            } catch (Exception e) {
            }
            saveRequest(request);
            WebUtils.issueRedirect(request, response, kickoutUrl);
            return false;
        }

        return true;
    }
}
