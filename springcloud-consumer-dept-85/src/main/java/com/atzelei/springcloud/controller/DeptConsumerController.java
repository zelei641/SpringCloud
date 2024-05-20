package com.atzelei.springcloud.controller;


import com.atzelei.springcloud.pojo.PerformInfo;
import com.atzelei.springcloud.utils.Response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.List;


@Controller
@RestController
public class DeptConsumerController
{
    //消费者 没有service
    //如何取到url:RestTemplate .... 供我们直接调用 就可以了
    //(url,实体:Map,Class<T> responseType

    @Autowired
    private RestTemplate restTemplate; //提供多种便捷访问远程http服务的方法,简单的RestFul服务模板

    //Ribbon 这里的地址应该是变量 通过服务名访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-PERFORMINFO-8081";

    /**
     * 得到所有的performinfo
     * @return
     */
    @GetMapping("/performinfo/getAll")
    public BaseResponse<List<PerformInfo>> getPerforminfoAll()
    {
        BaseResponse forObject = restTemplate.getForObject(REST_URL_PREFIX + "/performinfo/getAll", BaseResponse.class);
        return forObject;
    }

    @PostMapping("/performinfo/byStrGetInfo")
    public BaseResponse<List<PerformInfo>> byStrGetPerformInfo(@RequestBody String matchStr) throws UnsupportedEncodingException {

        // 创建请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // 或者 MediaType.TEXT_PLAIN 如果你发送纯文本

        // 创建请求实体，并设置请求体为字符串
        HttpEntity<String> requestEntity = new HttpEntity<>(matchStr, headers);


        BaseResponse forObject = restTemplate.postForObject(REST_URL_PREFIX + "/performinfo/byStrGetInfo?",requestEntity,BaseResponse.class);
        return forObject;
    }


    @GetMapping ("/hi")
    public String getHi(Long id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/hi?id=" + id,String.class);
    }




}
