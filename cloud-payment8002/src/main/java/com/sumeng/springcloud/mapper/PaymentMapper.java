package com.sumeng.springcloud.mapper;

import com.sumeng.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenzuolin
 * @Description
 * @date 2020/4/19 15:15
 */
@Mapper
public interface PaymentMapper {

    Integer inster(Payment payment);

    Payment gatPaymentById(@Param("id") Integer id);

    List<Payment> getList();
}
