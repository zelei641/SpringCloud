package com.atzelei.springcloud.controller;

import com.atzelei.springcloud.pojo.Dept;
import com.atzelei.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
public class MyConsumerController
{
    Map<Character, Integer> CharCount = new HashMap<Character, Integer>();

    @Autowired
    private DeptClientService service = null;

    @RequestMapping("/hi")
    public String get(@PathVariable("id") Long id)
    {
        return "Ribbon";
    }

    @RequestMapping("/consumer/dept/add")
    public Boolean addDept(Dept dept)
    {
        return this.service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll()
    {
        return this.service.queryAll();
    }



}
