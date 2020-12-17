package com.ya.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    private int[] maxSlidingWindow(int[] nums, int k){

        int len = nums.length;
        if(len * k == 0){
            return new int[0];
        }

        int[] res = new int[len - k + 1];

        for (int i = 0; i < len - k + 1; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }

        return res;

    }
}
