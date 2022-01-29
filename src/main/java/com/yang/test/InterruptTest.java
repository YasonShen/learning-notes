package com.yang.test;

public class InterruptTest {

    //计数器
    private static int count = 0;

    /**
     * 核心线程
     */
    public static void main(final String[] arguments) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        //休眠一会儿，然后中断
        t.sleep(200);
        t.interrupt();
    }


    /**
     * 线程实体（实现Runnable接口）
     */
    static class TestThread implements Runnable {
        public void run() {
            for (int i = 0; i < 500000; i++) {
                //判断线程是否被通知中断
                if (Thread.currentThread().isInterrupted()) {
                    //处理中断逻辑
                    break;
                }
                count++;
                System.out.println(count);
            }
        }
    }
}
