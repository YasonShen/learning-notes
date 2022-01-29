package com.yang.leetcode.editor.cn;

import java.util.List;
import java.util.Scanner;

public class Calculator {
    private double add(double a, double b) {
        return a + b;
    }

    private double sub(double a, double b) {
        return a - b;
    }

    // 乘法
    public double multiply(double a, double b) {
        return a * b;
    }

    // 除法
    public double div(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operator = scanner.next();
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double result = 0;
        Calculator calculator = new Calculator();
        switch (operator) {
            case "+":
                result = calculator.add(a, b);
                break;
            case "-":
                result = calculator.sub(a, b);
                break;
            case "*":
                result = calculator.multiply(a, b);
                break;
            case "/":
                result = calculator.div(a, b);
                break;
        }

        System.out.println(result);
    }
}
