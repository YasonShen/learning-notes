package com.ya.staticProxy;

/**
 * @author shenqiuyang3
 * @date 2020/10/31 16:49
 */
public class QiuProxy implements Qiu{

    private Qiu qiu;

    public QiuProxy(Qiu qiu){
        this.qiu = qiu;
    }

    @Override
    public void sayLove() {
        System.out.println("before ...");
        qiu.sayLove();
        System.out.println("after ...");
    }
}
