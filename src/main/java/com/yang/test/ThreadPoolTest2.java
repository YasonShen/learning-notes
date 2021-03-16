package com.yang.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author shenqiuyang3
 * @date 2021/2/24 16:23
 * @Description
 */
public class ThreadPoolTest2 {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(16), new ThreadPoolExecutor.CallerRunsPolicy());

        List<Future<String>> futureList = new ArrayList<>();
        Callable<String> callable = new MyCallable()    ;

        for (int i = 0; i < 10; i++) {
            Future<String> future = executor.submit(callable);
            futureList.add(future);
        }

        for (Future<String> future: futureList) {

            try{
                System.out.println(new Date()+"::"+future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
