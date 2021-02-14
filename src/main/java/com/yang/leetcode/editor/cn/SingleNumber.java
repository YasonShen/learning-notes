package com.yang.leetcode.editor.cn;

import java.util.ArrayList;

/**
 * @author shenqiuyang3
 * @date 2020/11/7 18:50
 */
public class SingleNumber {

    public static void main(String[] args) {



        int[] nums = {3,3,4,1,2,2,1};

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])){
                list.remove((Integer)nums[i]);
            }else {
                list.add(nums[i]);
            }
        }
        System.out.println(list.iterator().next());
//        Set<Integer> set = new HashSet<>();
//
//        for (int i : nums) {
//            if (!set.add(i)){
//                set.remove(i);
//            }
//        }
//        set.isEmpty() ? -1:set.iterator().next()
    }
}
