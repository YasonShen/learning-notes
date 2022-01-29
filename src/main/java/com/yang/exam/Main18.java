package com.yang.exam;


import java.util.Scanner;

public class Main18 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.length() == 0) {
            System.out.println("");
            return;
        }
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        int i = 0, j = 0;
        while (j < arr.length) {
            while (j < arr.length && arr[i] == arr[j]) {
                j++;
            }
            if (j - i == 1) {
                sb.append(arr[i]);
            } else {
                sb.append(j - i);
                sb.append(arr[i]);
            }
            i = j;
        }
        System.out.println(sb);
    }
}
