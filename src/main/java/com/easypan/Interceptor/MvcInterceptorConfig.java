package com.easypan.Interceptor;

/**
 * @Description:
 * @Author: lkl
 * @Date: 2023/10/28 17:22
 **/

/**
 * @Author: ljh
 * @ClassName MvcInterceptorConfig
 * @Description 注册SqlInterceptor拦截器到容器中
 * @date 2023/8/9 10:21
 * @Version 1.0
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //需要注册到容器中的拦截器
        registry.addInterceptor(new IPInterceptor())
                //所有请求都被拦截，静态资源也被拦截
                .addPathPatterns("/**");
//                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**"); // 放行的请求
    }
}