package com.yang.test;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DuplicateQueue {

    Queue<Integer> queue = new LinkedList<>();
    int i = 0;
    Object o = new Object();
    class Offer implements Runnable{

        @Override
        public void run() {
            synchronized (o){
                if (queue.contains(i)){
                    return;
                }
                System.out.println(Thread.currentThread().getName()+"插入"+i);
                queue.offer(i++);
            }
        }
    }

    class Poll implements Runnable{

        @Override
        public void run() {
            synchronized (o){
                if (queue.isEmpty()){
                    return;
                }
                Integer poll = queue.poll();
                System.out.println(Thread.currentThread().getName()+"删除"+poll);
            }
        }
    }

    @Test
    public void test() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 200, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        for (int i = 0; i < 300; i++) {
            threadPoolExecutor.execute(new Offer());
            threadPoolExecutor.execute(new Poll());
//            new Thread(new Offer()).start();
        }

        threadPoolExecutor.shutdown();
        while (Thread.activeCount() > 2){
            Thread.yield();
        }

    }
}
