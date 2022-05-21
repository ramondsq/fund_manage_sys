package com.qurui.fund_manage_sys.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        List<String> excludePaths = new ArrayList();
        excludePaths.add("/userLogin");
        excludePaths.add("/adminLogin");
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/**").excludePathPatterns(excludePaths);
    }
}
