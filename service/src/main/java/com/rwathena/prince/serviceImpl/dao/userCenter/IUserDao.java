package com.rwathena.prince.serviceImpl.dao.userCenter;

import com.rwathena.prince.user.TSysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ Author:     prince.
 * @ Date：      Created in 3:37 PM 12/13/2018
 * @ Description:
 * @ Version:     1.0
 */
@Mapper
public interface IUserDao {
    TSysUser findByLoginName(String map);
}