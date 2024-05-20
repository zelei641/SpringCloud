package com.atzelei.springcloud.dao;

import com.atzelei.springcloud.pojo.Dept;
import com.atzelei.springcloud.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface userDao
{
    public boolean adduser(user user);
}
