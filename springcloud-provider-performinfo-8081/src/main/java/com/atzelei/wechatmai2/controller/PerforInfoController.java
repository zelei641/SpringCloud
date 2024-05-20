package com.atzelei.wechatmai2.controller;


import com.atzelei.springcloud.request.PerformInfoRequest;
import com.atzelei.wechatmai2.model.pojo.PerformInfo;
import com.atzelei.wechatmai2.service.PerformInfoService;
import com.atzelei.wechatmai2.utils.Enms.ErrorCode;
import com.atzelei.wechatmai2.utils.Response.BaseResponse;
import com.atzelei.wechatmai2.utils.ResultUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/performinfo")
public class PerforInfoController
{
    @Autowired
    private PerformInfoService performInfoService;

    @Value("${file-save-path}")
    private String fileSavePath;

    @GetMapping("/getAll")
    public BaseResponse<List<PerformInfo>> getAllPerformInfo()
    {
        List<PerformInfo> allPerforInfo = performInfoService.getAllInfo();
        return ResultUtils.success(allPerforInfo);
    }

    @PostMapping("/byStrGetInfo")
    public BaseResponse<List<PerformInfo>> byStrGetPerformInfo(@RequestBody String matchStr) throws UnsupportedEncodingException {
        System.out.println("matchStr = " + matchStr);
        List<PerformInfo> allPerforInfo = performInfoService.byMatchStrInfo(matchStr);

        if (allPerforInfo.size() == 0)
        {
            return ResultUtils.error(ErrorCode.NULL_ERROR);
        }
        return ResultUtils.success(allPerforInfo);
    }

    @PostMapping("/addPerformInfo")
    public BaseResponse<Integer> addPerformInfo(@RequestBody PerformInfoRequest requestPerformInfo) {

       if (requestPerformInfo == null)
       {
           return ResultUtils.error(ErrorCode.NULL_ERROR);
       }

        int b = performInfoService.addPerforminfo(requestPerformInfo);

        System.out.println("b = " + b);
        return ResultUtils.success(b);
    }

    @PostMapping("/testFile")
    public BaseResponse<String> testFile(@RequestParam("file") MultipartFile fileUpload) {

        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        String tmpFilePath =  "D:\\Java idea porject\\weChatMai2//image//";

        //没有路径就创建路径
        File tmp = new File(tmpFilePath);
        if (!tmp.exists()) {
            tmp.mkdirs();
        }

        //文件的存储路径
        String resourcesPath = tmpFilePath + "//" + fileName;

        File upFile = new File(resourcesPath);
        try {
            fileUpload.transferTo(upFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String resUrl = "http://localhost:8081/images/" + fileName;

        return ResultUtils.success(resUrl);
    }
}
