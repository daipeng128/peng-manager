package com.peng;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication //Spring Boot核心注解，用于开启自动配置
@MapperScan("com.peng.*.mapper")
public class PengApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
            SpringApplication.run(PengApplication.class, args);
    }
}
