package com.yang.singleton;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author shenqiuyang3
 * @date 2020/10/31 10:59
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100,200,5, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5));

        for (int i = 0; i < 100; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    LazySingleton lazySingleton = LazySingleton.getInstance();
                    System.out.println(lazySingleton.toString());
                }
            });
        }
        System.out.println(executor.getActiveCount());
        executor.shutdown();
        System.out.println(executor.isTerminated());

    }
}
