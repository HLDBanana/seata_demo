package com.yhally.seata.order.feign;

import com.yhally.seata.common.domain.CommonResult;
import com.yhally.seata.order.feign.back.AccountServiceBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account",fallback = AccountServiceBack.class)
//@RequestMapping("/account")
public interface AccountService {

    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId,
                          @RequestParam("money") BigDecimal money);

}
