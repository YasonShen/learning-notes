package com.ya.test;

import java.util.ArrayList;

/**
 * @author shenqiuyang3
 * @date 2020/10/29 15:08
 */
public class StreamTest {

    public static void main(String[] args) {

//        空集合可以进行流操作，null不行
        ArrayList<String> list = new ArrayList<>();
//        list = null;
        list.stream().forEach(s -> {
            System.out.println(s);
        });

//        String s = new String("1");
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2);
        String temp = "hello";
        String str = new String("hello");
        String intern = str.intern();
        System.out.println(temp == intern);

        String s1 = "1";
        String s = new String("1");
//        s.intern();
        System.out.println(s.intern() == s1);

//        String s1 = "Hello";
//        String s2 = "Hello";
//        String s3 = "Hel" + "lo";
//        String s4 = "Hel" + new String("lo");
//        String s5 = new String("Hello");
//        String s6 = s5.intern();
//        String s7 = "H";
//        String s8 = "ello";
//        String s9 = s7 + s8;
//
//        System.out.println(s1 == s2);  // true
//        System.out.println(s1 == s3);  // true
//        System.out.println(s1 == s4);  // false
//        System.out.println(s1 == s9);  // false
//        System.out.println(s4 == s5);  // false
//        System.out.println(s1 == s6);
    }
}
