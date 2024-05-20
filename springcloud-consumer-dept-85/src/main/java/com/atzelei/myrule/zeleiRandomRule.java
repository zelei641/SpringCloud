package com.atzelei.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class zeleiRandomRule extends AbstractLoadBalancerRule {

    //每个服务访问5次 然后换下一个服务

    int currentServer = 0;
    int currentServerPoint = 0;

    public zeleiRandomRule() {
    }

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key)
    {

        if (lb == null)
        {
            return null;
        } else
        {
            Server server = null;

            while(server == null)
            {
                if (Thread.interrupted())
                {
                    return null;
                }

                List<Server> upList = lb.getReachableServers(); //获得还或者的服务
                List<Server> allList = lb.getAllServers(); //获得全部的服务
                int serverCount = allList.size();
                if (serverCount == 0) //没有服务了
                {
                    return null;
                }

                //int index = this.chooseRandomInt(serverCount); //生成随机数


                if (currentServerPoint == 5) //如果当前服务已经被连续调用了5次 就换服务
                {
                    currentServer ++;
                    if (currentServer >= serverCount)
                    {
                        currentServer = 0;
                    }

                    System.out.println("currentServer" + currentServer);

                    currentServerPoint = 0;
                }
                server = (Server)upList.get(currentServer);

                System.out.println("currentServerPoint" + currentServerPoint);

                if (server == null)
                {
                    Thread.yield();
                } else
                {
                    if (server.isAlive())
                    {
                        currentServerPoint ++;
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
                currentServerPoint ++;
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}