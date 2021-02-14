package com.yang.test;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

    private AtomicInteger sum = new AtomicInteger(0);
//    private volatile int sum = 0;

    private void add(){
        sum.getAndIncrement();
//        sum++;
    }

//    static int sum = 0;
    public static void main(String[] args) {

        VolatileTest vt = new VolatileTest();
//        ReentrantLock lock = new ReentrantLock();

        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
//                    lock.lock();
                    vt.add();
//                    lock.unlock();
                }
            }, String.valueOf(i));

            thread.start();
//            try {
//                thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(vt.sum);

    }
}


