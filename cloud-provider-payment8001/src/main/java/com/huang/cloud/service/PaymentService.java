package com.huang.cloud.service;

import com.huang.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author :huangao
 */
public interface PaymentService {

     int create(Payment payment);

     Payment getPaymentById(@Param("id") Long id);
}
