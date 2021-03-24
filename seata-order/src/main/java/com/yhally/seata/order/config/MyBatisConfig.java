package com.yhally.seata.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yhally.seata.order.dao")
public class MyBatisConfig {
}
