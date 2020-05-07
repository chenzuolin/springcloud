package com.sumeng.springcloud.controller;

import com.sumeng.springcloud.entity.Payment;
import com.sumeng.springcloud.jsonresult.JsonResult;
import com.sumeng.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author chenzuolin
 * @Description
 * @date 2020/4/19 16:26
 */
@RestController
@Slf4j
public class OrderController {

    public static  final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public JsonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,JsonResult.class);
    }

    @GetMapping("/consumer/payment/{id}")
    public JsonResult<Payment> gatPayment(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,JsonResult.class);
    }

    @GetMapping("/consumer/payment/list")
    public JsonResult<Payment> getList(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/list",JsonResult.class);
    }

    @GetMapping("/consumer/payment/disconvery")
    public JsonResult getDiscovery(){
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/discovery",JsonResult.class);
    }

    @GetMapping("/consumer/payment/getforentity/list")
    public JsonResult<Payment> getListEntity(){
        ResponseEntity<JsonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/list", JsonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return  forEntity.getBody();
        }else {
            return  new JsonResult<>(500,"操作失败！！！");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
