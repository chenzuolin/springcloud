package com.sumeng.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class FeignLog {

    @Bean
    Logger.Level feignlog(){
        return Logger.Level.FULL;
    }
}
