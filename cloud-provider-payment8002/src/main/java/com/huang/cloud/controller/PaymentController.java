package com.huang.cloud.controller;

import com.huang.cloud.entities.CommonResult;
import com.huang.cloud.entities.Payment;
import com.huang.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author :huangao
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);

        if(result > 0)
        {
            return new CommonResult(200,"server port:"+serverPort+"插入数据库成功: ",result);
        }else{
            return new CommonResult(444,"server port:"+serverPort+"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);

        if(payment != null)
        {
            return new CommonResult(200,"server port:"+serverPort+"查询成功:  ",payment);
        }else{
            return new CommonResult(444,"server port:"+serverPort+"没有对应记录,查询ID: "+id,null);
        }
    }
}
