package com.yang.DynamicProxy;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] A = new int[]{23, 4, 5, 2};
        int[] B = new int[]{2, 3, 3, 1};
        System.out.println(new Main().solution(A, B));
    }

    public int solution(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            set.add(Math.max(A[i], B[i]));
        }

        for (int i = 1; i <= len; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return len + 1;
    }
}
