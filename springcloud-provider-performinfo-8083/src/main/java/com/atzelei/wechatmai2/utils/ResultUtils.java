package com.atzelei.wechatmai2.utils;

import com.atzelei.wechatmai2.utils.Enms.ErrorCode;
import com.atzelei.wechatmai2.utils.Response.BaseResponse;

/**
 * 对返回类的封装
 */
public class ResultUtils
{
    public BaseResponse error(int code, String message,String descript)
    {
        BaseResponse baseResponse = new BaseResponse<>(code, null, message, descript);
        return baseResponse;
    }

    //方法重载
    public static BaseResponse error(ErrorCode errorCode)
    {
        BaseResponse baseResponse = new BaseResponse<>(errorCode.getCode(), null, errorCode.getMessage(), errorCode.getDescription());
        return baseResponse;
    }

    //成功返回
    public static BaseResponse success(Object data)
    {
        BaseResponse baseResponse = new BaseResponse<>(ErrorCode.SECCESS.getCode(), data, ErrorCode.SECCESS.getMessage(), ErrorCode.SECCESS.getDescription());
        return baseResponse;
    }

}
