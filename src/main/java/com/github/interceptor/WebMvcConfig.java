package com.github.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * 添加自定义组件
 * @author fromfield
 * @create 2017-10-31 15:50
 **/

@Component
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Resource
    private BaseInterceptor baseInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor);
    }
}
