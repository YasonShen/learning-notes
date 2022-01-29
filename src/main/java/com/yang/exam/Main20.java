package com.yang.exam;

import java.util.Scanner;

public class Main20 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            solve(line);
        }
    }

    private static void solve(String line) {
        int start = 0, end = 0, cnt ;
        StringBuilder sb = new StringBuilder();
        while (end < line.length()) {
            char c = line.charAt(start);
            cnt = 0;
            while (end < line.length() && line.charAt(end) == c) {
                cnt++;
                end++;
            }
            if (cnt > 1) {
                sb.append(cnt);
            }
            sb.append(c);
            start = end;
        }
        System.out.println(sb);
    }
}
