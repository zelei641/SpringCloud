package com.atzelei.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class user implements Serializable
{
    private Integer id;
    private String openid;

    private String avatarUrl;

    private String nickname;

    private Integer userrole;

}
