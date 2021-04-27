package com.yhally.seata.order.service.impl;

import com.yhally.seata.common.domain.CommonResult;
import com.yhally.seata.order.dao.OrderDao;
import com.yhally.seata.order.domain.Order;
import com.yhally.seata.order.feign.AccountService;
import com.yhally.seata.order.service.OrderService;
import com.yhally.seata.order.feign.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "seata-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("--------->开始新建订单");
        //1 新建订单
        orderDao.create(order);
        //2 扣减库存
        log.info("------------->订单微服务开始调用库存,做扣减Count");
        CommonResult st = storageService.decrease(order.getProductId(), order.getCount());
        log.info("------------->" + st.toString());
        if (st.getCode() != 200){
            throw new  RuntimeException("扣减库存失败");
        }
        log.info("------------->订单微服务开始调用库存,做扣减end");
        //3 扣减账户
        log.info("------------->订单微服务开始调用账户,做扣减Money");
        CommonResult ac = accountService.decrease(order.getUserId(), order.getMoney());
        if (ac.getCode() != 200){
            throw new  RuntimeException("扣减账户失败");
        }
        log.info("------------->" + ac.toString());
        log.info("------------->订单微服务开始调用账户,做扣减end");

        //4 修改订单状态
        log.info("------------->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("------------->修改订单状态结束");

        log.info("------------->下订单结束了");
    }
}
