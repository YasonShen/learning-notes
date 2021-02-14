package com.yang.test;

/**
 * @author shenqiuyang3
 * @date 2021/1/16 16:42
 * @Description
 */
public class AddBigNumber {

    private String solve(String s, String t){

//        long a = Long.parseLong(s);
//        long b = Long.parseLong(t);
//
//        long c = a + b;
//
//        return Long.toString(c);
        StringBuilder sb = new StringBuilder();
        int sLen = s.length()-1, tLen = t.length()-1, carry = 0;

        while(sLen >= 0 || tLen >= 0 || carry != 0){
            int a = sLen < 0 ? 0 : s.charAt(sLen--) - '0';
            int b = tLen < 0 ? 0 : t.charAt(tLen--) - '0';

            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "212";
        String t = "445";

        String solve = new AddBigNumber().solve(s, t);
        System.out.println(solve);
    }
}
