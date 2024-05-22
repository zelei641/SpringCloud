package com.atzelei.springcloud.controller;

import  com.atzelei.springcloud.pojo.Dept;
import com.atzelei.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController
{
    @Autowired
    private DeptService deptService;

    @HystrixCommand(fallbackMethod = "hystrixQueryById")
    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id)
    {
        Dept dept = deptService.queryById(id);

        if (dept == null)
        {
            throw new RuntimeException("id =>" + id + "，不存在该用户，或者信息无法找到");
        }

        return dept;
    }


    //备选方案
    public Dept hystrixQueryById(@PathVariable("id") Long id)
    {
        return new Dept()
                .setDeptno(id)
                .setDname("id =>" + id + "没有对应信息，null -- Q@Hystrix")
                .setDb_source("no this database in MySql");
    }

    /*
    学校作业
     */
    @HystrixCommand(fallbackMethod = "ribbonHi")
    @GetMapping("/hi")
    public String getHi()
    {
        return "这是正常的请求Feign";
    }

    public String ribbonHi() {

        return "这个是降级服务使用Ribbon";
    }
}
