package com.yang.leetcode.editor.cn;

/**
 * 二进制反向拼接
 * 限定语言：Kotlin、Typescript、Python、C++、Groovy、Rust、C#、Java、Go、C、Scala、Javascript、Ruby、Swift、Php、Python 3
 * 输入一个正整数n，请将1至n的每个数反向二进制表示后拼接起来生成新的二进制结果，最终返回拼接二进制对应的十进制数字对109+7取余的结果
 * @author shenqiuyang
 */

//输入
//        4
//        输出
//        185
//        说明
//        十进制下的1,2,3,4分别对应二进制1,10,11,100
//        将每个二进制反向后拼接得到10111001，对应的十进制返回结果为185
public class ConcatenateReverseBinary {


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = 20;
        for(int i = 1; i <= n; i++){
            String s = Integer.toBinaryString(i);
            StringBuilder tmp = new StringBuilder(s).reverse();
            sb.append(tmp);
        }
        String s = sb.toString();
        long res = 0;
        long mul = 0;
        for(int i = s.length()-1; i >= 0; i--){
            String str = String.valueOf(s.charAt(i));
            res += Integer.parseInt(str) * Math.pow(2, mul);
            mul++;
        }
        System.out.println(res % 1000000007);
    }
}
