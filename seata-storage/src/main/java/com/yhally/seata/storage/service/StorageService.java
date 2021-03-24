package com.yhally.seata.storage.service;

public interface StorageService {

    int decrease(Long productId, Integer count);

}
