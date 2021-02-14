package com.yang.leetcode.editor.cn;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2883 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        String res = "";

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j-i<2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if (j - i + 1 > max){
                        max = j - i + 1;
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

