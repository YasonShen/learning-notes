package com.yang.test;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shenqiuyang3
 * @date 2020/12/25 14:14
 * @Description
 */
public class PrintOne2Hundred {


    private ReentrantLock lock = new ReentrantLock();
    volatile int i = 0;
    volatile int flag = 0;

//    AtomicInteger i = new AtomicInteger(0);

    class Thread1 implements Runnable {
        @Override
        public void run() {
            while (i < 100) {
                lock.lock();
                try {
                    while (flag % 3 == 0) {
                        System.out.println("current thread is " + Thread.currentThread().getName() + " i = " + i);
                        flag++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Thread2 implements Runnable {
        @Override
        public void run() {
            while (i < 100) {
                lock.lock();
                try {
                    while (flag % 3 == 1) {
                        System.out.println("current thread is " + Thread.currentThread().getName() + " i = " + i);
                        flag++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Thread3 implements Runnable {
        @Override
        public void run() {

            while (i < 100) {
                lock.lock();
                try {
                    while (flag % 3 == 2) {  //多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        System.out.println("current thread is " + Thread.currentThread().getName() + " i = " + i);
                        flag++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    @Test
    public void test() {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
        new Thread(new Thread3()).start();

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
    }

//    public static void main(String[] args) {
//
//        PrintOne2Hundred p = new PrintOne2Hundred();
//
//        new Thread(new Thread1()).start();
//        new Thread(new Thread2()).start();
//        new Thread(new Thread3()).start();
//    }
}




