package com.yang.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author shenqiuyang3
 * @date 2020/10/31 21:55
 */
public class ProxyFactoryTest {

    private Object object;

    public static Object getProxyInstance(Object object){

        Object o = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before ...");
                //返回执行目标方法的对象，即代理对象
                Object invoke = method.invoke(object, args);
                System.out.println("after ...");
                return invoke;
            }
        });
        return o;
    }
}
