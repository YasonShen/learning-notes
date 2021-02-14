package com.yang.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author shenqiuyang3
 * @date 2020/10/19 10:00
 */
public class ProxyHandler implements InvocationHandler {

    private Object obj;

    public ProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke ");
        Object invoke = method.invoke(obj, args);
        System.out.println("after invoke ");

        return invoke;
    }
}
