package com.ya.leetcode;

public class IsPalindString {

    public boolean isPalindString(String s){
        StringBuffer stringBuffer = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stringBuffer.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer res = new StringBuffer(stringBuffer).reverse();
        return stringBuffer.toString().equals(res.toString());
    }

    public static void main(String[] args) {
        String s = "aabbAA";

        System.out.println(new IsPalindString().isPalindString(s));
    }
}
