package com.ya.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shenqiuyang3
 * @date 2020/10/17 16:49
 */
public class CasAndUnsafe {

    static int total = 0;

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 100; j++) {
                    lock.lock();
//                    synchronized (Object.class){
                    total++;
//                    }
                    lock.unlock();
                }
            }).start();
        }

//        Thread.sleep(500);

        countDownLatch.countDown();

        Thread.sleep(1000);
//        while (Thread.activeCount() > 2) {
//            Thread.yield();
//        }
//        TimeUnit.NANOSECONDS.sleep(2);
//        Thread.sleep();

        System.out.println(total);
    }
}
