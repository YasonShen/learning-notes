package com.yang.exam;

import java.util.Scanner;

public class ColorPaper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        int res = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int m = scanner.nextInt();
                res += m;
            }
        }
        System.out.println(res);
    }
}
