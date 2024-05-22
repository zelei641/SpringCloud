package com.atzelei.wechatmai2.service;


import com.atzelei.springcloud.pojo.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCarService
{
    public List<Integer> getUserShopCar(Integer id);


    public Integer getUserShopCarHave(Integer performperformId, Integer userId);

    public int addShopCar(Integer performperformId,Integer userId);
}
