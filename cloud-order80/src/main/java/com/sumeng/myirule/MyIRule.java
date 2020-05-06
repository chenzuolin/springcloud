package com.sumeng.myirule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyIRule {

    @Bean
    public IRule myRibbonIRule(){
        //定义为随机
        return  new RandomRule();
    }
}
