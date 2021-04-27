package com.yhally.seata.storage.controller;

import com.yhally.seata.common.domain.CommonResult;
import com.yhally.seata.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping(value = "/decrease")
    public CommonResult decrease(@RequestParam("productId") @Valid @NotNull Long productId,
                                 @RequestParam("count") Integer count) {
        log.info("开始调用扣减库存");
        int suc = storageService.decrease(productId,count);
        log.info("扣减成功：" + suc);
        return new CommonResult(200, "扣减库存成功");
    }

}

