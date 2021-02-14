package com.yang.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author shenqiuyang3
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("123","456");
        map.put(1,"string");
        map.put("shen", "ya");

        int[] nums = new int[4];
        Arrays.fill(nums,2);

        String s ="123456";
        System.out.println(s.substring(1,5));
        for (Map.Entry<Object, Object> entry : map.entrySet()) {

            System.out.println("key值为："+entry.getKey()+"  value值为："+entry.getValue());
        }

        Iterator<Map.Entry<Object, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Object, Object> next = iterator.next();
            System.out.println("key值为："+next.getKey()+"  value值为："+next.getValue());

        }
    }
}
