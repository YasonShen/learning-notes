package com.yang.exam;

import java.util.*;

public class Main6 {
    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int c = sc.nextInt();
            for (int j = 0; j < c; j++) {
                int num = sc.nextInt();
                list.add(num);
            }
            map.put(i+1, list);
        }

        for (int i = 0; i < q; i++) {
            int h = sc.nextInt();
            int k = sc.nextInt();
            if (h == 0){
                on(k);
            }else{
                close(k);
            }
        }
    }

    private static void on(int k){
        int count = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getKey() == k){
                List<Integer> value = entry.getValue();
                count += value.size();
            }
        }
        System.out.println(count);
    }

    private static void close(int k){
        int count = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getKey() == k){
                entry.setValue(new ArrayList<>());
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            count += value.size();
        }

        System.out.println(count);
    }
}
