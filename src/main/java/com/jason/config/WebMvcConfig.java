package com.jason.config;

import com.jason.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Created by 我不管我最帅 on 2019/4/13.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
    @Bean
    public LoginInterceptor getLoginIntercepter(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginIntercepter()).addPathPatterns("/**");
    }
}
