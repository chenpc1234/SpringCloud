package com.chen.cloud.alibaba.service;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/7/06/07  10:11
 */
public class GlobalBlockHandler {
    public static String blockHandler(BlockException blockException){
        return " global fail ";
    }
}
