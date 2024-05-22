package com.atzelei.wechatmai2.service.impl;

import com.atzelei.springcloud.pojo.user;
import com.atzelei.wechatmai2.dao.UserInfoMapper;
import com.atzelei.wechatmai2.service.UsermInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UsermInfoServiceImpl implements UsermInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public int loginUser(user user) {
        return userInfoMapper.userLogin(user);
    }

    @Override
    public user getHaveUser(String openid) {
        return userInfoMapper.getHaveUser(openid);
    }

    @Override
    public int updateUser(user user) {
        return userInfoMapper.updateUser(user);
    }


}
