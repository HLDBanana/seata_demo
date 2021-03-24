package com.yhally.seata.storage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yhally.seata.storage.dao")
public class MyBatisConfig {
}
