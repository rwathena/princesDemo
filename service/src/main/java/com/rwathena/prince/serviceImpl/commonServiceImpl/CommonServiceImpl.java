package com.rwathena.prince.serviceImpl.commonServiceImpl;

import com.rwathena.prince.serviceImpl.dao.ICommonDao;
import com.rwathena.prince.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author:     prince.
 * @ Date：      Created in 4:12 PM 12/12/2018
 * @ Description:
 * @ Version:     1.0
 */
 @Service("commonService")
 public class CommonServiceImpl implements ICommonService {

    @Autowired
    ICommonDao commonDao;
    @Override
    public String query() {
        commonDao.query();
        return "";
    }
}