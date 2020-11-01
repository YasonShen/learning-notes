package com.ya.test;

import jdk.nashorn.internal.ir.CallNode;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shenqiuyang3
 * @date 2020/10/18 19:51
 */
public class VolatileTest2 {

    int total;

    private AtomicInteger sum = new AtomicInteger(0);

    @Test
    public void test() throws InterruptedException {


        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {   //j越大，线程不安全导致的结果不符合预期出现的频率越高
//                    synchronized (this){
//                    sum.getAndIncrement();
                        total++;
//                    }
                }
            }).start();
        }

        Thread.sleep(5000);
        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(total);
        System.out.println(sum);
    }
}
