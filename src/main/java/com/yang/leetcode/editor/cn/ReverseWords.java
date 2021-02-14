package com.yang.leetcode.editor.cn;

public class ReverseWords {

    public String reverseWords(String s){

//        String[] s1 = s.split(" ");
//        StringBuffer[] stringBuffers = new StringBuffer[s1.length];
//        for (int i = 0; i < s1.length; i++){
//            StringBuffer sb = new StringBuffer(s1[i]);
//            StringBuffer reverse = sb.reverse();
//            stringBuffers[i] = reverse;
//        }
//
//        StringBuffer res = new StringBuffer();
//        for (StringBuffer stringBuffer : stringBuffers){
//            res.append(stringBuffer);
//            res.append(" ");
//        }
//
//        return res.reverse().toString();
////        StringBuffer sb = new StringBuffer(s);
////        StringBuffer reverse = sb.reverse();
////        return reverse.toString();

        String[] strings = s.trim().split(" ");
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals("")){
                continue;
            }
            if (i == 0){
                stringBuffer.append(strings[i].trim());
            }else {
                stringBuffer.append(strings[i].trim()).append(" ");
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(new ReverseWords().reverseWords(s));
    }
}
