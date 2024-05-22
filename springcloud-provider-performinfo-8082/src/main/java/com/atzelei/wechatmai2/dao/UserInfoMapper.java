package com.atzelei.wechatmai2.dao;


import com.atzelei.springcloud.pojo.user;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserInfoMapper {

    public int userLogin(user user);

    @Select("select * from userinfo where openid = #{openid}")
    public user getHaveUser(String openid);

    public int updateUser(user user);
}