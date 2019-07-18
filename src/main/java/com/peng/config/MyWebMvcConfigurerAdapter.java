package com.peng.config;

import com.peng.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author hll
 * @date 2018年1月6日 上午11:23:37   
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
 
    /**
      * 配置静态资源
      */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
        registry.addResourceHandler("/image/**").addResourceLocations("classpath:/image/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        super.addResourceHandlers(registry);
    }

    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 用于添加拦截规则
        //excludePathPatterns 用于排除拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
//        .excludePathPatterns("/login") //登录页
//        .excludePathPatterns("/hlladmin/user/sendEmail") //发送邮箱
                .excludePathPatterns("/login/**"); //打开注册页面
//                .excludePathPatterns("/login/register") //用户注册
//                .excludePathPatterns("/hlladmin/user/login"); //用户登录
        super.addInterceptors(registry);
    }
}