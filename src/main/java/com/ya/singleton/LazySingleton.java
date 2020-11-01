package com.ya.singleton;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author shenqiuyang3
 * @date 2020/10/31 10:56
 */
public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton(){

    }

    public  static LazySingleton getInstance(){
        if (instance == null){
            synchronized (LazySingleton.class){
                if (instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,5, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5));

        for (int i = 0; i < 5; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    HungrySingleton hungrySingleton = HungrySingleton.getInstance();
                    System.out.println(hungrySingleton.toString());
                }
            });
        }
        System.out.println(executor.getActiveCount());
        executor.shutdown();
        System.out.println(executor.isTerminated());
    }
}
