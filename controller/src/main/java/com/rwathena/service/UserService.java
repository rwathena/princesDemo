package com.rwathena.service;

import org.springframework.security.core.userdetails.User;

/**
 * 用户服务
 *
 * @author WangHQ
 * @date 2017-07-13 13:25
 */
public interface UserService {

    /**
     * 根据登录名获取用户
     *
     * @param name 登录名
     * @return
     * @author WangHQ
     * @date 2017-07-13
     */
    User findByLoginName(String name);
}
