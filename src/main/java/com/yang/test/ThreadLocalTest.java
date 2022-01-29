package com.yang.test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ThreadLocalTest {

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
        threadLocal.set("s1");
        threadLocal1.set(1);
        System.out.println(threadLocal.get());
        System.out.println(threadLocal1.get());

    }
}
