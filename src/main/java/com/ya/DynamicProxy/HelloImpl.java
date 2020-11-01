package com.ya.DynamicProxy;

/**
 * 被代理类
 * @author shenqiuyang3
 * @date 2020/10/19 9:50
 */
public class HelloImpl implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("hello shenya");
    }
}
