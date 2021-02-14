package com.yang.DynamicProxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author shenqiuyang3
 * @date 2020/10/19 10:07
 */
public class ProxyTest {

    @Test
    public void staticProxyTest(){

        HelloInterface hello = new HelloProxy();
        hello.sayHello();
    }

    @Test
    public void dynamicProxyTest(){

        HelloInterface hello = new HelloImpl();
        ProxyHandler proxyHandler = new ProxyHandler(hello);

        ByeInterface bye = new ByeImpl();
        ProxyHandler proxyHandler1 = new ProxyHandler(bye);

        HelloInterface helloInterface = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), proxyHandler);
        ByeInterface byeInterface = (ByeInterface) Proxy.newProxyInstance(bye.getClass().getClassLoader(), bye.getClass().getInterfaces(), proxyHandler1);
        helloInterface.sayHello();
        byeInterface.byeHello();
    }
}
