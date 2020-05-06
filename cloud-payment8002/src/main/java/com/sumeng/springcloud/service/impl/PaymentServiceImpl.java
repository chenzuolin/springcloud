package com.sumeng.springcloud.service.impl;

import com.sumeng.springcloud.entity.Payment;
import com.sumeng.springcloud.mapper.PaymentMapper;
import com.sumeng.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenzuolin
 * @Description
 * @date 2020/4/19 15:33
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public Integer inster(Payment payment) {
        return paymentMapper.inster(payment);
    }

    @Override
    public Payment gatPaymentById(Integer id) {
        return paymentMapper.gatPaymentById(id);
    }

    @Override
    public List<Payment> getList() {
        return paymentMapper.getList();
    }
}
