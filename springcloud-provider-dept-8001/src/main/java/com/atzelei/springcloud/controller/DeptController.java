package com.atzelei.springcloud.controller;

import com.atzelei.springcloud.pojo.Dept;
import com.atzelei.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.ResponseWrapper;
import java.util.List;

@RestController
public class DeptController
{
    @Autowired
    private DeptService deptService;

    //获取一些配置信息 得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/hello")
    public String addDept(Dept dept)
    {

         return "hello world!";
    }

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id)
    {
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll()
    {
        return deptService.queryAll();
    }

    //注册进来的服务 可以获取一些消息
    @RequestMapping("/dept/discovery")
    public Object discovery()
    {
        //获取 微服务列表的清单
        List<String> services = client.getServices();

        System.out.println("services = " + services);

        //得到一个具体的微服务信息 通过具体的微服务id
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT-8001");

        for (ServiceInstance instance : instances)
        {
            System.out.println(instance.getHost() + "\t"
                    + instance.getPort() + "\t"
                    + instance.getUri() + "\t"
                    + instance.getServiceId());
        }

        return this.client;
    }

}
