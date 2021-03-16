package com.yang.DynamicProxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author shenqiuyang3
 * @date 2021/3/2 11:25
 * @Description
 */
public class MyProxyFactory {

    public static Object getProxyInstance(Object target){

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before proxy");
                        Object invoke = method.invoke(target, args);
                        System.out.println("after proxy");
                        return invoke;
                    }
                });
//        (Object proxy, Method method, Object[] args)-> {
//                        System.out.println("before proxy");
//                        Object invoke = method.invoke(target, args);
//                        System.out.println("after proxy");
//                        return invoke;
//                });
    }
}
