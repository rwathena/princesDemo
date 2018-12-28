package com.rwathena.prince;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * @ Author:     prince.
 * @ Date：      Created in 4:09 PM 10/15/2018
 * @ Description:
 * @ Version:     1.0
 */
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@ImportResource("classpath:/spring/spring-dubbo-provider.xml")
//@DubboComponentScan("com.rwathena.prince.service")
public class PrinceStartApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PrinceStartApplication.class, args);
    }

}