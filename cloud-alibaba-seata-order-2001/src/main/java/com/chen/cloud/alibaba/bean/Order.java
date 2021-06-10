package com.chen.cloud.alibaba.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/8/05/08  15:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_order")
public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private Long money;
    private Integer status;
}