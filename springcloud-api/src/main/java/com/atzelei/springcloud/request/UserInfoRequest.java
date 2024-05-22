package com.atzelei.springcloud.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoRequest
{
    private String session_key;

    private String openid;

    private String avatarUrl;

    private String nickname;

}
