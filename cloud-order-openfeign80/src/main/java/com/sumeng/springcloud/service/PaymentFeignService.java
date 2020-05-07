package com.sumeng.springcloud.service;

import com.sumeng.springcloud.jsonresult.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/list")
    public JsonResult list();

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
