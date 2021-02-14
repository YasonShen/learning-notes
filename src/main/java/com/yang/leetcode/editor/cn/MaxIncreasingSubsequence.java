package com.yang.leetcode.editor.cn;

/**
 * @author shenqiuyang3
 * @date 2020/12/17 14:29
 * @Description 最大上升子序列
 */
public class MaxIncreasingSubsequence {

    public int maxIncreasingSubsequence(int[] nums){

        int[] dp = new int[nums.length];
        int result = 0;

        dp[0] = nums[0];
//        Arrays.fill(dp, 0);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j]+nums[i],dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1, 7, 3, 5, 9, 4, 8};
        System.out.println(new MaxIncreasingSubsequence().maxIncreasingSubsequence(nums));
    }
}
