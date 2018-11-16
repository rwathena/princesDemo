package com.rwathena.prince;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author:     prince.
 * @ Date：      Created in 4:09 PM 10/15/2018
 * @ Description:
 * @ Version:     1.0
 */
@RestController
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class PrinceStartApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PrinceStartApplication.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

}