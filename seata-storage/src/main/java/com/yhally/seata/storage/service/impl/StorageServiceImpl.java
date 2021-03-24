package com.yhally.seata.storage.service.impl;

import com.yhally.seata.storage.dao.StorageDao;
import com.yhally.seata.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {

    private StorageDao storageDao;

    @Override
    public int decrease(Long productId, Integer count) {
        return storageDao.decrease(productId, count);
    }

    @Autowired
    public void setStorageDao(StorageDao storageDao) {
        this.storageDao = storageDao;
    }
}
