package com.yang.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author shenqiuyang3
 * @date 2021/1/4 11:33
 * @Description
 */
public class LRUCacheTests {

    private Map<Integer, Integer> map;

    public int[] LRU(int[][] operators, int k){

        map = new LinkedHashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int[] op : operators) {
            int key = op[1];
            switch (op[0]){
                case 1:
                    if (map.size() == k){
                        Integer first = map.entrySet().iterator().next().getKey();
                        map.remove(first);
                    }else if (map.containsKey(key)){
                        map.remove(key);
                    }
                    map.put(key, op[2]);
                    break;
                case 2:
                    if (!map.containsKey(key)){
                        res.add(-1);
                        continue;
                    }
                    res.add(map.get(key));
                    map.remove(key);
                    map.put(key, map.get(key));
            }
        }
        int[] ints = res.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }
}
