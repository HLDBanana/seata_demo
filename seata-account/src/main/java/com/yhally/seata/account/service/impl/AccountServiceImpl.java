package com.yhally.seata.account.service.impl;

import com.yhally.seata.account.dao.AccountDao;
import com.yhally.seata.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Override
    public int decrease(Long userId, BigDecimal money) {
//        try {
//            // 模拟超时异常
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return accountDao.decrease(userId, money);
    }

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
