package com.chen.cloud.alibaba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.cloud.alibaba.bean.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/8/06/08  16:54
 */
@Mapper
public interface StorageDao extends BaseMapper<Storage> {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
