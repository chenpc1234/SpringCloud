package com.chen.cloud.alibaba.service.impl;

import com.chen.cloud.alibaba.dao.StorageDao;
import com.chen.cloud.alibaba.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/8/06/08  16:48
 */
@Service
public class StorageServiceImpl implements IStorageService {
    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId,count);
    }
}
