package com.yang.leetcode.editor.cn;

import java.util.*;

//设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
//        set(key, value)：将记录(key, value)插入该结构
//        get(key)：返回key对应的value值
//        [要求]
//        set和get方法的时间复杂度为O(1)
//        某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
//        当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
//        若opt=1，接下来两个整数x, y，表示set(x, y)
//        若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
//        对于每个操作2，输出一个答案
//        示例1
//        输入
//        复制
//        [[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
//        返回值
//        复制
//        [1,-1]
/**
 * @author shenqiuyang3
 * @date 2020/11/7 21:04
 */
public class LRUCache {

    public int[] LRU (int[][] operators, int k) {

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int[] a : operators){
            int key = a[1];
            switch (a[0]){
                case 1:
                    if (map.size() == k){
                        Integer next = map.keySet().iterator().next();
                        map.remove(next);
                    }else if (map.containsKey(key)){
                        map.remove(key);
                    }
                    map.put(key, a[2]);
                case 2:
                    if (!map.containsKey(key)){
                        list.add(-1);
                    }else {
                        map.remove(key);

                        list.add(map.get(key));
                    }

            }
        }

        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }
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
    }
}
