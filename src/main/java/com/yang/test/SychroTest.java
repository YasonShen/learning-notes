package com.yang.test;

import org.junit.Test;

public class SychroTest {

    private static int num = 0;
    Object o = new Object();
    class Add implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                synchronized (o) {
                    num++;
                }
            }
        }
    }

    @Test
    public void main() {
        SychroTest instance = new SychroTest();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Add()).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(num);
    }
}
