package com.atzelei.wechatmai2.service.impl;


import com.atzelei.springcloud.request.PerformInfoRequest;
import com.atzelei.wechatmai2.dao.PerformInfoMapper;
import com.atzelei.wechatmai2.model.pojo.PerformInfo;
import com.atzelei.wechatmai2.service.PerformInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformInfoServiceImpl implements PerformInfoService {

    @Autowired
    private PerformInfoMapper performInfoMapper;

    @Override
    public List<PerformInfo> getAllInfo() {

        List<PerformInfo> allPerformInfo = performInfoMapper.getAllPerformInfo();
        return allPerformInfo;
    }

    @Override
    public List<PerformInfo> byMatchStrInfo(String matchStr) {
        List<PerformInfo> allPerformInfo = performInfoMapper.byMatchGetInfo(matchStr);
        return allPerformInfo;
    }

    @Override
    public int addPerforminfo(PerformInfoRequest performInfoRequest) {
        return performInfoMapper.addPerformInfo(performInfoRequest);
    }

    @Override
    public int deletePerformInfo(Integer id) {
        return performInfoMapper.deletePerformInfo(id);
    }

    @Override
    public PerformInfo getPerformInfoById(Integer id) {
        return performInfoMapper.getPerformInfoById(id);
    }
}
