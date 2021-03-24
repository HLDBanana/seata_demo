package com.yhally.seata.storage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {

    int decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
