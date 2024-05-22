package com.atzelei.wechatmai2.service.impl;

import com.atzelei.wechatmai2.dao.ShopCarMapper;
import com.atzelei.wechatmai2.service.ShopCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopCarServiceImpl implements ShopCarService {

    @Resource
    private ShopCarMapper shopCarMapper;

    @Override
    public List<Integer> getUserShopCar(Integer id) {
        return shopCarMapper.getUserShopCar(id);
    }

    @Override
    public Integer getUserShopCarHave(Integer performperformId, Integer userId) {
        return shopCarMapper.getUserShopCarHave(performperformId, userId);
    }

    @Override
    public int addShopCar(Integer performperformId, Integer userId) {
        return shopCarMapper.addShopCar(performperformId, userId);
    }
}
