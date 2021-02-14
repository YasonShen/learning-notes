package com.yang.leetcode.editor.cn;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
}

public class LevelOrder {

    private int[] levelOrder(TreeNode root){

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return new int[0];
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            res.add(temp.val);
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<List<Integer>> levelOrder2(TreeNode root){

        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            while (len-- > 0){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            res.add(list);
        }

        return res;
    }
}
