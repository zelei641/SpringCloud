package com.atzelei.wechatmai2.service;


import com.atzelei.springcloud.request.PerformInfoRequest;
import com.atzelei.wechatmai2.model.pojo.PerformInfo;

import java.util.List;

public interface PerformInfoService
{
    public List<PerformInfo> getAllInfo();

    public List<PerformInfo> byMatchStrInfo(String matchStr);

    public int addPerforminfo(PerformInfoRequest performInfoRequest);
}
