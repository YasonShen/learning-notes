package com.yang.exam;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        int q = scanner.nextInt();
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int u = scanner.nextInt();
            int k = scanner.nextInt();
            String str = line.substring(0, u);
            int j = 1;
            while (k != 0) {
                while (str.charAt(0) != str.charAt(j % str.length())) j++;
                k--;
                if (j >= u && k > 0) break;
                j++;
            }
            if (k == 0) res[i] = j - 1;
            else res[i] = -1;

        }

        for (int i = 0; i < q; i++) {
            System.out.println(res[i]);
        }
    }
}
