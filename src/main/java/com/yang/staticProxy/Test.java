package com.yang.staticProxy;

import com.yang.staticProxy.impl.QiuImpl;

/**
 * @author shenqiuyang3
 * @date 2020/10/31 16:51
 */
public class Test {

    public static void main(String[] args) {
        Qiu qiu = new QiuImpl();
        Qiu qiuProxy = new QiuProxy(qiu);
        qiuProxy.sayLove();
    }
}
