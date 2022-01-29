package com.yang.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Main9 {

    private static final int N = 1000007;

    public static void main(String[] args) {
        boolean[] isPrime = new boolean[N];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        int t = (int) Math.sqrt(N);
        for (int i = 0; i <= t; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j <= t; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int M = scanner.nextInt();

            for (int i = 1; i <= M; i++) {
                int L = scanner.nextInt();
                int R = scanner.nextInt();
                solve(isPrime, L, R);
            }
        }
    }

    private static void solve(boolean[] isPrime, int a, int b) {

        int ans = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime[i]) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
