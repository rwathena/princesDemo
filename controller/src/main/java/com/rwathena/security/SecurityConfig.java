package com.rwathena.security;

import com.rwathena.prince.service.IUserService;
import com.rwathena.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    @Autowired
    private UserService userService;//获取用户信息服务

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * 返回一个实现UserDetailsService接口的detail类
     *
     * @return 用户信息服务类
     * @author WangHQ
     * @date 2017-07-13
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return (name) -> userService.findByLoginName(name);
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 配置请求相关
     *
     * @param http http
     * @throws Exception 异常
     * @author WangHQ
     * @date 2017-07-13
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/token/**", "/user/**", "/sessionService/**", "/message/**","/common/login").permitAll()
            .anyRequest().authenticated().and()
//          .formLogin()
                //登录成功后可使用loginSuccessHandler()存储用户信息，可选。
//                .successHandler(loginSuccessHandler())
//                .and()
                .logout().permitAll()//退出页面
                .and()
                .csrf().disable()
        //.httpBasic().disable()
//                .sessionManagement().maximumSessions(1)
//                .maxSessionsPreventsLogin(true)
        ;
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }
}