package com.atzelei.wechatmai2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com/atzelei/wechatmai2/dao")
public class WeChatMai2Application {

    public static void main(String[] args) {
        SpringApplication.run(WeChatMai2Application.class, args);
    }

}
