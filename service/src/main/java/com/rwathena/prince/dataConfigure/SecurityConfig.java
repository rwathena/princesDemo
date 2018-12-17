package com.rwathena.prince.dataConfigure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ Author:     prince.
 * @ Date：      Created in 3:20 PM 12/13/2018
 * @ Description:
 * @ Version:     1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//  启用方法级别的权限认证
public class SecurityConfig extends WebSecurityConfigurerAdapter {

}