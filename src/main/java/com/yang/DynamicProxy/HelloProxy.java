package com.yang.DynamicProxy;

/**
 * 代理类
 * @author shenqiuyang3
 * @date 2020/10/19 9:51
 */
public class HelloProxy implements HelloInterface{

    private HelloInterface helloInterface = new HelloImpl();

    @Override
    public void sayHello() {
        System.out.println("before invoke sayHello");
        helloInterface.sayHello();
        System.out.println("after invoke sayHello");
    }
}
