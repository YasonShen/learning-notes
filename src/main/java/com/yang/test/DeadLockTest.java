package com.yang.test;

/**
 * @author shenqiuyang3
 * @date 2021/3/6 14:00
 * @Description
 */
public class DeadLockTest {

    public static void main(String[] args) {

        Object o1 = new Object();
        Object o2 = new Object();

        new Thread(()->{
            synchronized (o1){
                try{
                    o2.wait();
//                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){

                }
            }
        }).start();

        new Thread(()->{
            synchronized (o2){
                try{
                    o2.wait();
//                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (o1){

                }
//                System.out.println("退出線程2");
            }

        }).start();


    }
}
