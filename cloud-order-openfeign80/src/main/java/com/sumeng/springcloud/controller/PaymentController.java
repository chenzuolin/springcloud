package com.sumeng.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.sumeng.springcloud.jsonresult.JsonResult;
import com.sumeng.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/list")
    public JsonResult getList(){
        return paymentFeignService.list();
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String getTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }
}
