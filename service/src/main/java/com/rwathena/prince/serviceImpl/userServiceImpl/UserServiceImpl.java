package com.rwathena.prince.serviceImpl.userServiceImpl;

import com.rwathena.prince.service.IUserService;
import com.rwathena.prince.serviceImpl.dao.userCenter.IUserDao;
import com.rwathena.prince.user.TSysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author:     prince.
 * @ Date：      Created in 3:33 PM 12/13/2018
 * @ Description:
 * @ Version:     1.0
 */
@Service("userService")
 public class UserServiceImpl implements IUserService {

 @Autowired
 IUserDao userDao;
    @Override
    public TSysUser findByLoginName(String param) {
        return userDao.findByLoginName(param);
    }
}