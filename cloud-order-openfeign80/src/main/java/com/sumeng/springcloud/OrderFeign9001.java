package com.sumeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderFeign9001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeign9001.class,args);
    }
}
