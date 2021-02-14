package com.yang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenqiuyang3
 * @date 2020/11/25 20:53
 */
public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int tag = nums[i];
            nums[Math.abs(tag)-1] = -Math.abs(nums[Math.abs(tag)-1]);
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        System.out.println(new FindDisappearedNumbers().findDisappearedNumbers(nums));
    }
}
