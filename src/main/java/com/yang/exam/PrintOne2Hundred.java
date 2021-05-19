package com.yang.exam;

import java.util.concurrent.locks.ReentrantLock;

public class PrintOne2Hundred {

    private static int state = 0;
    static ReentrantLock lock = new ReentrantLock();
    static int num = 0;

    static class Thread1 extends Thread {
        @Override
        public void run() {
            while (num < 100) {
                try {
                    lock.lock();
                    while (state % 3 == 0) {
                        state++;
                        System.out.println(Thread.currentThread().getName() + ":" + num++);
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            while (num < 100) {
                try {
                    lock.lock();
                    while (state % 3 == 1) {
                        state++;
                        System.out.println(Thread.currentThread().getName() + ":" + num++);
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Thread3 extends Thread {
        @Override
        public void run() {
            while (num < 100) {
                try {
                    lock.lock();
                    while (state % 3 == 2) {
                        state++;
                        System.out.println(Thread.currentThread().getName() + ":" + num++);
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
        new Thread3().start();

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
    }
}
