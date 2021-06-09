package com.chen.cloud.alibaba.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/8/06/08  16:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    /**
     * ID
     */
    private Long id;
    /**
     * 产品ID
     */
    private Long productId;
    /**
     * 库存总数
     */
    private Integer total;
    /**
     * 已用库存
     */
    private Integer used;
    /**
     * 剩余库存
     */
    private Integer residue;
}
