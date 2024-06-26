package com.atzelei.springcloud.service;

import com.atzelei.springcloud.dao.DeptDao;
import com.atzelei.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService
{

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {

        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
