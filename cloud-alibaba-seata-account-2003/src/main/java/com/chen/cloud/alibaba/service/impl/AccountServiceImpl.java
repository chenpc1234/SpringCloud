package com.chen.cloud.alibaba.service.impl;

import com.chen.cloud.alibaba.dao.AccountDao;
import com.chen.cloud.alibaba.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/8/06/08  17:14
 */
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void decrease(Long userId, Long money) {
        accountDao.decrease( userId,  money);
    }
}
