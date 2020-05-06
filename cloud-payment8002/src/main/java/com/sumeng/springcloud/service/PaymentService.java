package com.sumeng.springcloud.service;

import com.sumeng.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenzuolin
 * @Description
 * @date 2020/4/19 15:32
 */
public interface PaymentService {
    Integer inster(Payment payment);

    Payment gatPaymentById(@Param("id") Integer id);

    List<Payment> getList();
}
