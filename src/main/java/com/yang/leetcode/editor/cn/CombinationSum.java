package com.yang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int k, int n) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(list, n, k, 1);
        return res;
    }

    private void dfs(LinkedList<Integer> path, int n, int k, int start){
        if(path.size() == k){
            res.add(new ArrayList(path));
            return;
        }

        for(int i = start; i <= n; i++){
            if(path.size() == k){
                break;
            }

            path.add(i);
            dfs(path, n, k, i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
//        int k = 9, n = 45;
        List<List<Integer>> lists = new CombinationSum().combine(2, 4);
        System.out.printf(lists.toString());
    }

}
