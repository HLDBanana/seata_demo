package com.yhally.seata.account.controller;

import com.yhally.seata.account.service.AccountService;
import com.yhally.seata.common.domain.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,
                                 @RequestParam("money") BigDecimal money) {
        log.info("开始调用扣减账户余额");
        int res =  accountService.decrease(userId, money);
        log.info("扣减金额成功：" + res);
        return new CommonResult(200, "扣减账户余额成功");
    }

}
