package com.yang.leetcode.editor.cn;

import java.util.*;

/**
 * @author shenqiuyang3
 * @date 2021/1/24 18:03
 * @Description
 */
public class SubSets {

    List<List<Integer>> res = new ArrayList<>();
    ArrayList list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backTrack(nums, 0);

        return res;
    }

    public void backTrack(int[] nums, int j) {
        res.add(new ArrayList<>(list));

        for (int i = j; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        backtrack(0, nums, res, new ArrayList<Integer>());
//        return res;
//
//    }
//
//    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
//        res.add(new ArrayList<>(tmp));
//        for (int j = i; j < nums.length; j++) {
//            tmp.add(nums[j]);
//            backtrack(j + 1, nums, res, tmp);
//            tmp.remove(tmp.size() - 1);
//        }
//    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = new SubSets().subsets(nums);

        Iterator<List<Integer>> iterator = subsets.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
