package com.atzelei.springcloud;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.context.annotation.Configuration;

public class Filer extends ZuulFilter
{

    @Override
    public String filterType() {
        System.out.println("MyFiler");
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        System.out.println("true = " + true);
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("MyFiler");
        return null;
    }
}
