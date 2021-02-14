package com.yang.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTestDemo2 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch cp = new CountDownLatch(1);  //裁判计数器
        CountDownLatch xs = new CountDownLatch(4);  //选手计数器

        for (int i = 0; i < 4; i++) {
            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"---选手等待裁判吹哨---");
                    try {
                        cp.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("---裁判哨响，"+Thread.currentThread().getName()+"起跑---");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"到达终点");
                    xs.countDown();
                }
            };
            executorService.execute(runnable);
        }

        Thread.sleep(100);
        System.out.println("---裁判吹哨---");
        cp.countDown();
        System.out.println("---裁判等待选手到达终点，准备积分---");
        xs.await();
        System.out.println("所有选手都到达终点");
        System.out.println("裁判"+Thread.currentThread().getName()+"汇总成绩排名");
    }
}
