package com.rwathena.prince.service;


import com.rwathena.prince.user.TSysUser;

import java.util.Map;

/**
 * @ Author:     prince.
 * @ Date：      Created in 2:25 PM 12/13/2018
 * @ Description:
 * @ Version:     1.0
 */
public interface IUserService {
    TSysUser findByLoginName(String param);
}