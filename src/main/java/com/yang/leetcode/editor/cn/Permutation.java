package com.yang.leetcode.editor.cn;

import java.util.*;

/**
 * @author shenqiuyang3
 * @date 2021/1/24 17:12
 * @Description
 */
public class Permutation {

    Deque<Integer> list = new ArrayDeque<>();
    ArrayList<Deque<Integer>> res = new ArrayList<>();

    public ArrayList<Deque<Integer>> perm(int[] nums){

        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        recur(nums, list, used);
        return res;
    }

    public void recur(int[] nums, Deque<Integer> list, boolean[] used){

        if (list.size() == nums.length){
            res.add(new LinkedList<>(list)) ;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && used[i - 1]){
                continue;
            }
            if (used[i]) continue;
            list.addLast(nums[i]);
            used[i] = true;
            recur(nums, list, used);
            list.removeLast();
            used[i] = false;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        ArrayList<Deque<Integer>> perm = new Permutation().perm(nums);

        Iterator<Deque<Integer>> iterator = perm.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
