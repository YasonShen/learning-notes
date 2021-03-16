package com.yang.test;

import net.minidev.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author shenqiuyang3
 * @date 2021/3/12 11:32
 * @Description
 */
public class StreamLambdaTest {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list.stream().forEach(inn -> inn += 10);

        list.stream().forEach(inn ->{
            inn += 10;
            list1.add(inn);
//            list2.addAll(list1);
            list1.stream().forEach(one -> list2.add(one));
        });
        System.out.println(JSONArray.toJSONString(list2));
//        List<String> list2 = new ArrayList<>();

    }
}
