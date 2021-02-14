package com.yang.leetcode.editor.cn;

public class ModifyString {

    public String modifyString(String s) {
        int len = s.length();
        char[] sb = s.toCharArray();

        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '?'){
                char a = 'a';
                while((i > 0 && sb[i-1] == a) || (i < len-1 && sb[i+1] == a)){
                    a++;
                }
                sb[i] = a;
            }
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        String s = "?zs";
        System.out.println(new ModifyString().modifyString(s));
    }
}
