package com.yang.DynamicProxy.impl;

import com.yang.DynamicProxy.QiuInterface;

/**
 * @author shenqiuyang3
 * @date 2020/10/31 16:56
 */
public class QiuImpl implements QiuInterface {
    @Override
    public void sayLove() {
        System.out.println("love ya");
    }
}
