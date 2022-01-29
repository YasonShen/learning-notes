package com.yang.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Main22 {

    private static int count(String source, String target){
        int ans = 0;
        int index = source.indexOf(target);

        if (index != -1){
            ans++;
            index++;
            while (true){
                if (source.indexOf(target, index) != -1){
                    ans++;
                    index++;
                }else{
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        int N = Integer.parseInt(words[0]);
        int M = Integer.parseInt(words[1]);
        String six = "6";
        String sevenTeen = "17";
        int ans = 0;
        for (int i = N; i < M; i++) {
            ans += count(String.valueOf(i), six);
            ans += count(String.valueOf(i), sevenTeen);
        }
        System.out.println(ans);
    }
}
