package com.atzelei.wechatmai2.controller;


import com.atzelei.springcloud.pojo.user;
import com.atzelei.springcloud.request.PerformInfoRequest;
import com.atzelei.springcloud.request.UserInfoRequest;
import com.atzelei.wechatmai2.dao.UserInfoMapper;
import com.atzelei.wechatmai2.model.pojo.PerformInfo;
import com.atzelei.wechatmai2.service.PerformInfoService;
import com.atzelei.wechatmai2.service.UsermInfoService;
import com.atzelei.wechatmai2.utils.Enms.ErrorCode;
import com.atzelei.wechatmai2.utils.Response.BaseResponse;
import com.atzelei.wechatmai2.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController
{
    @Autowired
    private UsermInfoService usermInfoService;


    @PostMapping("/login")
    public BaseResponse<String> userLogin(@RequestBody UserInfoRequest userInfoRequest, HttpServletRequest request)
    {

        String session_key = userInfoRequest.getSession_key();
        String openid = userInfoRequest.getOpenid();
        String avatarUrl = userInfoRequest.getAvatarUrl();
        String nickname = userInfoRequest.getNickname();

        if (openid == null)
        {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        user haveUser = usermInfoService.getHaveUser(openid);

        if (haveUser == null)
        {
            user user = new user();
            user.setOpenid(openid);
            user.setAvatarUrl(avatarUrl);
            user.setNickname(nickname);
            user.setUserrole(1);
            usermInfoService.loginUser(user);
        }
        else
        {
            user user = new user();
            user.setId(haveUser.getId());
            user.setOpenid(openid);
            user.setAvatarUrl(avatarUrl);
            user.setNickname(nickname);
            user.setUserrole(1);
            int i = usermInfoService.updateUser(user);
            if (i == 0)
            {
                return ResultUtils.error(ErrorCode.SYSTEM_ERROR);
            }

            request.getSession().setAttribute("openid", user);
        }

        request.getSession().getId();
        return ResultUtils.success(request.getSession().getId());
    }

    @GetMapping("/getLoginUser")
    public BaseResponse<user> getLoginUser(HttpServletRequest request) {

        user loginUser = (user)request.getSession().getAttribute("openid");

        System.out.println("openid = " + loginUser);

        if (loginUser == null)
        {
            return ResultUtils.error(ErrorCode.NOT_LOGIN);
        }
        return ResultUtils.success(loginUser);
    }

    public BaseResponse<user> getLoginUserNotRequest(HttpServletRequest request) {

        user loginUser = (user)request.getSession().getAttribute("openid");

        System.out.println("openid = " + loginUser);

        if (loginUser == null)
        {
            return ResultUtils.error(ErrorCode.NOT_LOGIN);
        }
        return ResultUtils.success(loginUser);
    }

}
