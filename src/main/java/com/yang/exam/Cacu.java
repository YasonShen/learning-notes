package com.yang.exam;

import java.util.*;

public class Cacu {

    static void eval(Deque<Long> val, Deque<Character> ops){
        long b = val.pop();
        long a = val.pop();
        char op = ops.pop();
        long c = 0;
        switch (op) {
            case '+': c = a + b; break;
            case 'x': c = a * b; break;
            case '@': c = a | (a + b); break;
        }
        val.push(c);
    }


    public static void calculate(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('x', 2);
        map.put('@', 3);

        Deque<Long> val = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                long num = 0;
                while (j < len && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + (s.charAt(j) - '0');
                    j++;
                }
                val.push(num);
                i = j - 1;
            }

            if (!Character.isDigit(c)) {
                int pri = map.get(c);
                while (!ops.isEmpty() && pri <= map.get(ops.peek())) {
                    eval(val, ops);
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {
            eval(val, ops);
        }
        System.out.println(val.pop());
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        calculate(line);
    }
}
