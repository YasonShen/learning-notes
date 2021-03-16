package com.yang.DynamicProxy.test;

/**
 * @author shenqiuyang3
 * @date 2021/3/2 11:25
 * @Description
 */
public class MyInterImpl implements MyInter{

    @Override
    public void saySomething() {
        System.out.println("say something");
    }
}
