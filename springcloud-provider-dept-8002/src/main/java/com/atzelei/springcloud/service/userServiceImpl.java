package com.atzelei.springcloud.service;

import com.atzelei.springcloud.dao.userDao;
import com.atzelei.springcloud.pojo.user;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService
{

    @Autowired
    private userDao userDao;

    @Override
    public boolean adduser(user user) {
        return userDao.adduser(user);
    }
}
