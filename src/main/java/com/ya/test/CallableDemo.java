package com.ya.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("shenya");
            }
        });

        executorService.execute(() -> {
            System.out.println("shenya");
        });
    }
}
