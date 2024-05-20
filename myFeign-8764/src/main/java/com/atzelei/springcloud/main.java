package com.atzelei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.atzelei.springcloud"}) //扫描包
public class main
{
    public static void main(String[] args) {
        SpringApplication.run(main.class,args);
    }
}
