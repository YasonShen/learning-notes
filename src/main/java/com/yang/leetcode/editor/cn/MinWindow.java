package com.yang.leetcode.editor.cn;

public class MinWindow {

    public static String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] win = new int[128];
        int left = 0, right = 0, count = 0, len = Integer.MAX_VALUE, start = 0, cnt = 0;
        for(int i = 0; i < t.length(); i++){
            need[t.charAt(i)]++;
        }
        for (int i = 0; i < need.length; i++) {
            if(need[i] != 0){
                cnt++;
            }
        }

        while(right < s.length()){
            char c = s.charAt(right);
            right++;

            if(need[c] != 0){
                win[c]++;
                if(win[c] == need[c]){
                    count++;
                }
            }

            while(count == cnt){
                if(right-left < len){
                    start = left;
                    len = right-left;
                }
                char d = s.charAt(left);
                left++;
                if(need[d] != 0){
                    if(need[d] == win[d]){
                        count--;
                    }
                    win[d]--;
                }
            }
        }

        return len == Integer.MAX_VALUE? "" : s.substring(start, start+len);
    }

    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        String s1 = minWindow(s, t);
        System.out.println(s1);
    }
}
