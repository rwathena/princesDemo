package com.rwathena.security;

import com.rwathena.prince.security.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @param
 * @author WangHQ
 * @description: 登录成功后的方法
 * <p>
 * 类的注释
 * @return
 * @throws
 * @date 2018/10/8 11:02
 */
public class LoginSuccessHandler extends
        SavedRequestAwareAuthenticationSuccessHandler {

    /**
     * @param request
     * @param response
     * @param authentication
     * @return void
     * @throws
     * @description: 登录成功后执行
     * <p>
     * onAuthenticationSuccess 方法的注释
     * @author WangHQ
     * @date 2018/10/8 11:03
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException,
            ServletException {
        //获得授权后可得到用户信息   可使用SUserService进行数据库操作
        SecurityUser userDetails = (SecurityUser) authentication.getPrincipal();
        /* Set<SysRole> roles = userDetails.getSysRoles();*/
        //输出登录提示信息  
        System.out.println("管理员 " + userDetails.getUsername() + " 登录");

        System.out.println("IP :" + getIpAddress(request));

        super.onAuthenticationSuccess(request, response, authentication);
    }

    /**
     * @description: 获取ip
     *
     * getIpAddress 方法的注释
     *
     * @param request
     * @return java.lang.String
     * @throws
     * @author WangHQ
     * @date 2018/10/8 11:03
     */
    String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
