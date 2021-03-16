package com.yang.DynamicProxy.test;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author shenqiuyang3
 * @date 2021/3/2 11:30
 * @Description
 */
public class TestApplication {

    public static void main(String[] args) {
        MyInter proxyInstance = (MyInter) MyProxyFactory.getProxyInstance(new MyInterImpl());

        proxyInstance.saySomething();
    }
}
