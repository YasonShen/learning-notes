package com.yang.DynamicProxy;

import com.yang.DynamicProxy.impl.QiuImpl;

/**
 * @author shenqiuyang3
 * @date 2020/10/31 17:01
 */
public class QiuProxyTest {

    public static void main(String[] args) {

        QiuInterface qiu = new QiuImpl();

//        QiuInterface o = (QiuInterface) Proxy.newProxyInstance(qiu.getClass().getClassLoader(), qiu.getClass().getInterfaces(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                method.invoke(proxy, args);
//                return proxy;
//            }
//        });
        QiuInterface instance = (QiuInterface) ProxyFactoryTest.getProxyInstance(qiu);
        instance.sayLove();
    }
}
