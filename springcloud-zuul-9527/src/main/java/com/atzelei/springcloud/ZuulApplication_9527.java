package com.atzelei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy //zuul启动注解
public class ZuulApplication_9527
{
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_9527.class, args);
    }

    @Bean
    public Filer perFiler()
    {
        return new Filer();
    }
}
