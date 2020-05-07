package com.sumeng.springcloud;

import com.sumeng.myirule.MyIRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyIRule.class)
public class Order9001 {
    public static void main(String[] args) {
        SpringApplication.run(Order9001.class,args);
    }
}
