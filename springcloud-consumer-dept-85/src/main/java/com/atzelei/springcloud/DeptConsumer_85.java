package com.atzelei.springcloud;

import com.atzelei.myrule.zeleiRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = zeleiRule.class) //在微服务启动的时候就能去加载自定义的ribbon类
public class DeptConsumer_85
{
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_85.class,args);
    }
}
