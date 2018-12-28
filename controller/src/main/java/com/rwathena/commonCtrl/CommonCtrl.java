package com.rwathena.commonCtrl;

import com.rwathena.prince.security.SecurityUser;
import com.rwathena.prince.service.ICommonService;
import com.rwathena.prince.service.IUserService;
import com.rwathena.prince.user.TSysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author:     prince.
 * @ Date：      Created in 6:00 PM 12/12/2018
 * @ Description:
 * @ Version:     1.0
 */
@RestController
@RequestMapping("/common")
public class CommonCtrl {

    @Autowired
    ICommonService service;
    @Autowired
    IUserService iUserService;

    @Autowired
    private HttpSession session;//全局session

    @Autowired
    private AuthenticationManager myAuthenticationManager;//授权管理器

    @GetMapping("/home")
    String home() {
        service.query();
        TSysUser user = iUserService.findByLoginName("00100182");
        return "Hello World!";
    }

    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody TSysUser sysUserDTO, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(sysUserDTO.getUserCode(), sysUserDTO.getPassword());
        Authentication authentication = myAuthenticationManager.authenticate(authRequest); //调用loadUserByUsername

        SecurityContextHolder.getContext().setAuthentication(authentication);
        //认证通过后向session中添加相关信息
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        TSysUser user1;
        TSysUser user = ((SecurityUser) userDetails).getSysUserDTO();
        HttpSession  httpSession=request.getSession(true);
        String sessionId=httpSession.getId();
        user1 = (TSysUser)httpSession.getAttribute("sysUser");
        //登录日志
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sysUser", user);
        if(user1 == null)
        session.setAttribute("sysUser", user);
        session.setMaxInactiveInterval(10);//设置统一超时时间
        System.out.println(session.getId());

        return null;
    }
}