package com.yhally.seata.order.feign.back;

import com.yhally.seata.common.domain.CommonResult;
import com.yhally.seata.order.feign.StorageService;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Han LiDong
 * @create: 2021/3/24 09:46
 * @update: 2021/3/24 09:46
 */
@Component
public class StorageServiceBack implements StorageService {
    @Override
    public CommonResult decrease(Long productId, Integer count) {
        return new CommonResult(500,"调用失败");
    }
}
