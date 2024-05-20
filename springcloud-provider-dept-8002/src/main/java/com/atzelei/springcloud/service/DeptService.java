package com.atzelei.springcloud.service;

import com.atzelei.springcloud.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeptService
{
    public boolean addDept(Dept dept);


    public Dept queryById(Long id);


    public List<Dept> queryAll();
}
