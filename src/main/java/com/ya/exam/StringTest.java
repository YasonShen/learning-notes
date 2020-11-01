package com.ya.exam;

import java.util.Random;

public class StringTest {

    private static boolean isReverse(String s, int N){
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : strings) {
//            String temp = string.substring(string.length() - N, string.length());
//            StringBuilder sb = new StringBuilder(temp).reverse();
//            sb.append(string.substring(0, N));

            String temp = string.substring(string.length() - N, string.length()) + string.substring(0, N);
            if (temp.equals(string) == false) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "sasa enen yaya qiqi";
        int N = 2;
        System.out.println(isReverse(s,2));
        Random random = new Random();
        System.out.println(random.nextInt(5));


    }
}
