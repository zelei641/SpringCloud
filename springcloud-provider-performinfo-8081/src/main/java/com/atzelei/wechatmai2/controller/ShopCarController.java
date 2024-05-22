package com.atzelei.wechatmai2.controller;


import com.atzelei.springcloud.pojo.user;
import com.atzelei.springcloud.request.UserInfoRequest;
import com.atzelei.wechatmai2.model.pojo.PerformInfo;
import com.atzelei.wechatmai2.service.PerformInfoService;
import com.atzelei.wechatmai2.service.ShopCarService;
import com.atzelei.wechatmai2.service.UsermInfoService;
import com.atzelei.wechatmai2.utils.Enms.ErrorCode;
import com.atzelei.wechatmai2.utils.Response.BaseResponse;
import com.atzelei.wechatmai2.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shopCar")
public class ShopCarController
{
    @Autowired
    private ShopCarService shopCarService;

    @Autowired
    private PerformInfoService performInfoService;

    @PostMapping("/addShopCar")
    public BaseResponse<List<PerformInfo>> addShopCar(@RequestBody Integer performperformId,HttpServletRequest request)
    {

        user loginUser = getLoginUser(request);
        if (loginUser == null)
        {
            return ResultUtils.error(ErrorCode.NOT_LOGIN);
        }

        if (performperformId <= 0)
        {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }

        Integer userShopCarHave = shopCarService.getUserShopCarHave(performperformId, loginUser.getId());
        if (userShopCarHave != null)
        {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }

        int i = shopCarService.addShopCar(performperformId, loginUser.getId());

        return ResultUtils.success(i);
    }


    @PostMapping("/getById")
    public BaseResponse<List<PerformInfo>> getUserShopCar(HttpServletRequest request)
    {

        user loginUser = getLoginUser(request);
        if (loginUser == null)
        {
            return ResultUtils.error(ErrorCode.NOT_LOGIN);
        }

        List<Integer> performInfoIdList = new ArrayList<Integer>();

        performInfoIdList = shopCarService.getUserShopCar(loginUser.getId());

        List<PerformInfo> ans = new ArrayList<PerformInfo>();
        for (Integer performperformId : performInfoIdList) {
            PerformInfo performInfoById = performInfoService.getPerformInfoById(performperformId);
            ans.add(performInfoById);
        }

        return ResultUtils.success(ans);
    }


    public user getLoginUser(HttpServletRequest request) {

        user loginUser = (user)request.getSession().getAttribute("openid");

        System.out.println("openid = " + loginUser);

        if (loginUser == null)
        {
            return null;
        }
        return loginUser;
    }

}
