package com.yang.exam;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Caculator {

    private static int cal(String line) {
        int sum = 0;
        Deque<Integer> num = new LinkedList<>();
        Deque<String> stack = new LinkedList<>();
        String[] s = line.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("+") || s[i].equals("-")) {
                stack.push(s[i]);
                String ca = stack.pop();
                Integer a = num.pop();
                Integer b = 0;
                if (num.size() != 0) {
                    b = num.pop();
                }
                int tem = 0;
                switch (ca) {
                    case "+":
                        tem = a + b;
                        sum += tem;
                    case "_":
                        tem = b - a;
                        sum += tem;
                }
            } else {
                num.push(Integer.valueOf(s[i]));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        System.out.println(cal(line));
    }
}
