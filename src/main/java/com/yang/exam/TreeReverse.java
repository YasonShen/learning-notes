//package com.yang.exam;
//
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class TreeReverse {
//
//    static class TreeNode {
//        TreeNode left;
//        TreeNode right;
//        int val;
//
//        public TreeNode(int val) {
//            this.val = val;
//        }
//
//        public TreeNode() {
//        }
//
//    }
//
//    private List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        List<List<Integer>> res = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> list = new ArrayList<>();
//
//            while (size-- > 0) {
//                TreeNode node = queue.poll();
//                list.add(node.val);
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//            res.add(list);
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode()
//    }
//}
