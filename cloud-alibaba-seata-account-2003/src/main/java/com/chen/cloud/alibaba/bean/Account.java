package com.chen.cloud.alibaba.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/8/06/08  17:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private Long userId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
