package com.atzelei.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class zeleiRule {

    @Bean
    public IRule myRule()
    {
        return new zeleiRandomRule();
    }

}
