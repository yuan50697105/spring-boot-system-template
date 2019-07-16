package com.yuan.spring.boot.app1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author yuane
 * @date 2019/7/13 1:01
 **/
@SpringBootApplication
public class SpringBootWebApplicationInitializer1 extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootWebApplication1.class);
    }
}