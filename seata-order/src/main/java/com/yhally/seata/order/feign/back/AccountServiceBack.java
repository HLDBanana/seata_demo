package com.yhally.seata.order.feign.back;

import com.yhally.seata.common.domain.CommonResult;
import com.yhally.seata.order.feign.AccountService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @description:
 * @author: Han LiDong
 * @create: 2021/3/24 09:44
 * @update: 2021/3/24 09:44
 */
@Component
public class AccountServiceBack implements AccountService {
    @Override
    public CommonResult decrease(Long userId, BigDecimal money) {
        return new CommonResult(500,"调用失败");
    }
}
