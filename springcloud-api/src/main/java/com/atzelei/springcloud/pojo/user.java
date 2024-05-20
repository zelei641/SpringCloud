package com.atzelei.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class user implements Serializable
{
    private String username; //主键

    private String password; //部门名称

    private String name;

}
