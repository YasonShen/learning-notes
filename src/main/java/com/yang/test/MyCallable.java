package com.yang.test;

import java.util.concurrent.Callable;

/**
 * @author shenqiuyang3
 * @date 2021/2/24 16:24
 * @Description
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }

}
