package com.ya.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTranverse {

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("123","456");
        map.put(1,"string");
        map.put("shen", "ya");

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
