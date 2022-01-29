package com.yang.exam;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int res = 0;
        for (int i = 0; i < K; i++) {
            int p = reverse(N * i);
            res = Math.max(res, p);
        }
        System.out.println(res);
    }

    private static Integer reverse(int num){
        int p = 0;
        while (num > 0){
            p = p * 10 + (num % 10);
            num /= 10;
        }
        return p;
    }
}


