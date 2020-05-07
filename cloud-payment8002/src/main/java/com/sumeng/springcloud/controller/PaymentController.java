package com.sumeng.springcloud.controller;

import com.sumeng.springcloud.entity.Payment;
import com.sumeng.springcloud.jsonresult.JsonResult;
import com.sumeng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenzuolin
 * @Description
 * @date 2020/4/19 15:35
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public JsonResult create(@RequestBody Payment payment){
        Integer rows = paymentService.inster(payment);
        log.info("============="+payment.toString()+"=============");
        if (rows != null && rows > 0){
            return new JsonResult(200,"添加成功,serverPort:"+serverPort,rows);
        }else{
            return new JsonResult(500,"添加失败",null);
        }
    }

    @GetMapping("/payment/{id}")
    public JsonResult getPaymentById(@PathVariable("id") Integer id){
        Payment payment = paymentService.gatPaymentById(id);
        if (!StringUtils.isEmpty(payment)){
            return new JsonResult(200,"查询成功,serverPort:"+serverPort,payment);
        }else {
            return new JsonResult(500,"查询失败!查询id为==>"+id,null);
        }
    }

    @GetMapping("/payment/list")
    public JsonResult list(){
        List<Payment> list = paymentService.getList();
        if (!StringUtils.isEmpty(list)){
            return new JsonResult(200,"查询成功,serverPort:"+serverPort,list);
        }else{
            return new JsonResult(500,"查询失败",null);
        }
    }
    @GetMapping("/payment/discovery")
    public JsonResult discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach((String server) ->{
            log.info("**********>"+server);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach((ServiceInstance instance) ->{
            log.info("=========>"+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        });
        return new JsonResult(200,"success，serverPort："+serverPort,discoveryClient);
    }
    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
