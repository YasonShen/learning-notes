package com.yang.DynamicProxy;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        int[] A = new int[]{1};
        int[] B = new int[]{3};
        System.out.println(solution(3, A, B));
    }

    public static int solution(int N, int[] A, int[] B) {
        // write your code in Java SE 8
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        int[] res = new int[A.length+1];
        //升序排序
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<Integer, Integer> e : list) {
            res[e.getKey()] = N--;
            hashmap.put(e.getKey(), N--);
        }

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += hashmap.get(A[i]);
            sum += hashmap.get(B[i]);
        }
        return sum;

    }
}
