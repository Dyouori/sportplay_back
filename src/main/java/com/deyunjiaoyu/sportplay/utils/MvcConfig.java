package com.deyunjiaoyu.sportplay.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.context.annotation.Bean;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    /**
     * 添加jwt拦截器，并指定拦截路径
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/sport/**")
         .excludePathPatterns("/sport/login", "/sport/register","/faceLogin"); // 排除不需要被拦截的路径
    }

    /**
     * jwt拦截器
     * */
    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

}
