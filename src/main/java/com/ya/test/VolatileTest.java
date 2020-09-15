package com.ya.test;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

//    private AtomicInteger sum = new AtomicInteger(0);
    private volatile int sum = 0;

    private void add(){
//        sum.getAndIncrement();
        sum++;
    }

    public static void main(String[] args) {

        VolatileTest vt = new VolatileTest();

        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    vt.add();
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


