package com.atzelei.springcloud.service;

import com.atzelei.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {

    //服务降级
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptno(id)
                        .setDname("这个id => " + id + "没有对应信息,客户端提供了降级的信息 这个服务已经被关闭")
                        .setDb_source("没有数据");
            }

            @Override
            public String getHi()
            {
                return "这是服务降级的使用Fegin";
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public Boolean addDept(Dept dept) {
                return null;
            }


        };
    }
}
