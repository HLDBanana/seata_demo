package com.yhally.seata.order.controller;

import com.yhally.seata.common.domain.CommonResult;
import com.yhally.seata.order.domain.Order;
import com.yhally.seata.order.feign.AccountService;
import com.yhally.seata.order.feign.StorageService;
import com.yhally.seata.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @GetMapping("/create")
    public CommonResult create() {
        Order order = new Order();
        order.setProductId((long)1);
        order.setUserId((long)1);
        order.setCount(10);
        order.setMoney(new BigDecimal(200.00));
        order.setStatus(1);
        orderService.create(order);
        return new CommonResult(200, "订单创建完成");
    }

    @GetMapping("/create1")
    public CommonResult create1() {
        CommonResult st = storageService.decrease((long)1, 10);
        return st;
    }

    @GetMapping("/create2")
    public CommonResult create2() {
        CommonResult ac = accountService.decrease((long)1, new BigDecimal(90.00));
        return ac;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
