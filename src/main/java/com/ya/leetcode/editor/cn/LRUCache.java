package com.ya.leetcode.editor.cn;

import java.util.*;

/**
 * @author shenqiuyang3
 * @date 2020/11/7 21:04
 */
public class LRUCache {

    private Map<Integer, Integer> map;
    private int cap;
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new LinkedHashMap(capacity);
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Integer value = map.get(key);
        map.remove(key);
        map.put(key,value);
        return value;
    }

    public void put(int key, int value) {

        if(map.keySet().contains(key)){
            map.remove(key);
        }else if (map.size() == cap){
            Integer key1 = map.entrySet().iterator().next().getKey();
            map.remove(key1);
        }
        map.put(key, value);
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,6);
        System.out.println(lruCache.get(1));
        lruCache.put(1,5);
        lruCache.put(1,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
//        lruCache.put(4,4);

//        Map<Integer, Integer> map = new LinkedHashMap<>();
//
//        map.put(2,2);
//        map.put(1,1);
//        map.put(3,3);
//        map.remove(1);
//        map.putIfAbsent(1,1);
//
//        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
//        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
//        Integer key1 = iterator.next().getKey();
//        Integer key2 = map.entrySet().iterator().next().getKey();

//        while (iterator.hasNext()){
//            Map.Entry<Integer, Integer> next = iterator.next();
//            Integer key = next.getKey();
//            Integer value = next.getValue();
//            System.out.println("key:"+key+", value:"+value);
//        }
    }
}
