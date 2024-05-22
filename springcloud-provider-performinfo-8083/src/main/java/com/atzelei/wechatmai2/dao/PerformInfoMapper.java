package com.atzelei.wechatmai2.dao;


import com.atzelei.springcloud.request.PerformInfoRequest;
import com.atzelei.wechatmai2.model.pojo.PerformInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PerformInfoMapper {

    @Select("select * from performinfo")
    public List<PerformInfo> getAllPerformInfo();
    public List<PerformInfo> byMatchGetInfo(String matchStr);

    //分页查询
    public List<PerformInfo> getPerformInfoLimit(Map<String, Object> map);

    //根据id查询信息
    @Select("select * from performinfo where id = #{id}")
    public PerformInfo getPerformInfoById(@Param("id") int id);


    @Update("update performinfo set title = #{title}, perfortype = #{perfortype}, performstar = #{performstar} where id = #{id})")
    public int updatePerformInfo(PerformInfo performInfo);

    @Delete("delete from performinfo where id = #{id}")
    public int deletePerformInfo(int id);

    public int addPerformInfo(PerformInfoRequest requestPerformInfo);


}