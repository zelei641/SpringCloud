package com.atzelei.wechatmai2.dao;


import com.atzelei.springcloud.pojo.user;
import com.atzelei.wechatmai2.utils.Response.BaseResponse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Mapper
@Repository
public interface ShopCarMapper {

    @Select("select performId from shopcar where userId = #{id}")
    public List<Integer> getUserShopCar(@Param("id") Integer id);

    @Select("select id from shopcar where performId = #{performId} and userId= #{userId}")
    public Integer getUserShopCarHave(@Param("performId") Integer performperformId, @Param("userId")Integer userId);

    @Insert("insert into shopcar(performId, userId) values (#{performId}, #{userId})")
    public int addShopCar(@Param("performId") Integer performperformId, @Param("userId")Integer userId);
}