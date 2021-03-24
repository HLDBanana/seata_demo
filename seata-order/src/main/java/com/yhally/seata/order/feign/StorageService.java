package com.yhally.seata.order.feign;

import com.yhally.seata.common.domain.CommonResult;
import com.yhally.seata.order.feign.back.StorageServiceBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage",fallback = StorageServiceBack.class)
//@RequestMapping("/storage")
public interface StorageService {

    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,
                          @RequestParam("count") Integer count);

}
