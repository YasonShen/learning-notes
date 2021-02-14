package com.yang.leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1402 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class LongestCommonPrefix {
//    public String longestCommonPrefix(String[] strs) {
//
//        if(strs.length == 0) return "";
//
//        StringBuilder res = new StringBuilder("");
//        String base = strs[0];
//
//        for(int i = 1; i < strs.length; i++){
//            for (int j = 0; j < Math.min(base.length(), strs[i].length()); j++) {
//                if (base.charAt(j) != strs[i].charAt(j)){
//                    break;
//                }else {
//                    res.append(base.charAt(j));
//                }
//            }
//            base = res.toString();
//            res = new StringBuilder("");
//        }
//        return base;
//    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0)return "";
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String s = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

