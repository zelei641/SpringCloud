package com.atzelei.wechatmai2.service;


import com.atzelei.springcloud.pojo.user;
import com.atzelei.springcloud.request.PerformInfoRequest;
import com.atzelei.wechatmai2.model.pojo.PerformInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsermInfoService
{
    public int loginUser(user user);

    public user getHaveUser(String openid);

    public int updateUser(user user);


}
