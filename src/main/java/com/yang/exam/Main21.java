package com.yang.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Main21 {

    static int[][] dp = new int[20][2];
    static int[] a = new int[20];

    private static int dfs(int pos, boolean if6, boolean limit){
        if (pos == 0){
            return 1;
        }
        if(!limit && dp[pos][if6 ? 1:0] != 0){
            return dp[pos][if6 ? 1 : 0];
        }

        int tmp = 0;
        int up = limit ? a[pos] : 9;
        for (int i = 0; i < up; i++) {
            if(if6  && i == 7){
                continue;
            }
            if (i == 6){
                continue;
            }

            tmp += dfs(pos-1, i==1, limit&&i==up);
        }
        if (!limit){
            dp[pos][if6 ? 1:0] = tmp;
        }
        return tmp;
    }

    static int solve(int x){
        int len = 0;
        while (x != 0){
            a[len++] = x %10;
            x /= 10;
        }
        return dfs(len, false,  true);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int sum = N-M+1;
        long exclude = solve(M) - solve(N-1);
        System.out.println(sum - exclude);
    }
}
