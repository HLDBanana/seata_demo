package com.yhally.seata.account.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yhally.seata.account.dao")
public class MybatisConfig {
}

