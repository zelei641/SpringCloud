package com.atzelei.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.atzelei.springcloud"}) //扫描包
public class FeignDeptConsumer_81
{
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_81.class,args);
    }
}
