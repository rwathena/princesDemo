package com.rwathena.commonCtrl;

import com.rwathena.prince.service.ICommonService;
import com.rwathena.prince.service.IUserService;
import com.rwathena.prince.user.TSysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/home")
    String home() {
        service.query();
        TSysUser user = iUserService.findByLoginName("00100182");
        return "Hello World!";
    }
}