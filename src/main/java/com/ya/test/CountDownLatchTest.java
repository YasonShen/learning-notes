package com.ya.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

//    static int sum = 3;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("子线程" + Thread.currentThread().getName() + "开始执行");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("子线程"+Thread.currentThread().getName()+"执行完成");
//                        sum--;
                        countDownLatch.countDown();//当前线程调用此方法，则计数减一
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            executorService.execute(runnable);
        }

//        final Object obj = new Object();
        System.out.println("主线程"+Thread.currentThread().getName()+"等待子线程执行完成...");
        try {
            countDownLatch.await();//阻塞当前线程，直到计数器的值为0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程"+Thread.currentThread().getName()+"开始执行...");
    }
}
