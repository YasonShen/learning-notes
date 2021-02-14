package com.yang.test;

import java.util.*;

/**
 * @author shenqiuyang3
 * @date 2021/1/14 18:32
 * @Description
 */
public class ZigzagLevelOrder {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        boolean flag = true;
        if (root == null) return new ArrayList<>();
        queue.offer(root);
        list.add(root.val);
        while (!queue.isEmpty()) {
            list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode tem = queue.poll();
                if (flag) {
                    list.add(tem.val);
                } else {
                    list.add(0,tem.val);
                }
                if (tem.left != null) {
                    queue.offer(tem.left);
                }
                if (tem.right != null) {
                    queue.offer(tem.right);
                }
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(8);
        TreeNode g = new TreeNode(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        e.right = g;

        ArrayList<ArrayList<Integer>> treeNodes = new ZigzagLevelOrder().zigzagLevelOrder(a);
        Iterator<ArrayList<Integer>> iterator = treeNodes.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
    }
}
