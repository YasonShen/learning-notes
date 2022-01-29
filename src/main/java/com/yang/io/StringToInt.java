package com.yang.io;

public class StringToInt {

    private static int String2Int(String str) throws Exception {
        char[] strs = str.toCharArray();
        int result = 0;

        for (int i = 0; i < strs.length; i++) {
            char temp = strs[i];
            if(temp >= '0' && temp <= '9'){
                result += (temp - '0') * Math.pow(10, strs.length-1-i);
            }else{
                throw new Exception("");
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

        String str = "100";
        int res = String2Int(str);
        System.out.println(res);
    }
}

