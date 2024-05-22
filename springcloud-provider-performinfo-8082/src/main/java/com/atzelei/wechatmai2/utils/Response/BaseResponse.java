package com.atzelei.wechatmai2.utils.Response;

import com.atzelei.wechatmai2.utils.Enms.ErrorCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable
{
    private int code;

    private T data;

    private String message;

    private String descript;

    //构造方法
    public BaseResponse(int code, T data, String message,String descript)
    {
        this.code = code;
        this.data = data;
        this.message = message;
        this.descript = descript;
    }

    public BaseResponse(int code, T data)
    {
        this(code,data,"","");
    }


    public BaseResponse(ErrorCode code)
    {

        this(code.getCode(),null,code.getMessage(),code.getDescription());
    }
    
}
