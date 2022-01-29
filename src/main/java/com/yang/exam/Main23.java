package com.yang.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Main23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        boolean[][] f = new boolean[3][3];
        for (int i = 0; i < 3; ++i) {
            Arrays.fill(f[i], true);
        }
        System.out.println("");
    }
}
