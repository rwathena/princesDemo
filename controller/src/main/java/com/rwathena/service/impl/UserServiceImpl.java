package com.rwathena.service.impl;

import com.rwathena.prince.security.SecurityUser;
import com.rwathena.prince.service.IUserService;
import com.rwathena.prince.user.TSysUser;
import com.rwathena.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务
 *
 * @author WangHQ
 * @date 2017-07-13 13:25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserService iUserService;//用户service

    /**
     * 根据登录名获取用户
     *
     * @param loginName 登录名
     * @return 用户实例
     * @author WangHQ
     * @date 2017-07-13
     */
    @Override
    public SecurityUser findByLoginName(String loginName) {
        TSysUser userDTO = iUserService.findByLoginName(loginName);
        if (userDTO != null) {
            // 创建spring security安全用户
            String password = userDTO.getPassword();
            List<GrantedAuthority> authorities = new ArrayList<>();
            return new SecurityUser(loginName, password, authorities, userDTO);
        } else {
            throw new UsernameNotFoundException("用户[" + loginName + "]不存在");
        }
    }

}
