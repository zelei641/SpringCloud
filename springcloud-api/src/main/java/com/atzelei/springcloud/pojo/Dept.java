package com.atzelei.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Dept implements Serializable //实体类
{
    private Long deptno; //主键

    private String dname; //部门名称

    //这个数据存在于那个数据库 一个服务对应一个数据库  同一个信息可能存在不同的数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }

    /*
    链式写法
    Dept dept = new Dept()

    dept.setDetpno(11).setDname("sss").setDb_source("001");
     */

}
