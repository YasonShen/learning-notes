package com.yang.test;

public class InterruptTest2 {

    static class StopThread extends Thread{
        private int i = 0;
        private int j = 0;

        @Override
        public void run(){
            synchronized (this){
                ++i;
                try{
                    Thread.sleep(10000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                ++j;
            }
        }

        public void print(){
            System.out.println("i="+i+" j="+j);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        StopThread stopThread = new StopThread();
        stopThread.start();
//        Thread.sleep(1000);
        stopThread.interrupt();
        System.out.println(stopThread.isInterrupted());
        while (stopThread.isAlive()){

        }
        System.out.println(stopThread.isInterrupted());
        System.out.println("main线程结束");
        stopThread.print();
    }

}
