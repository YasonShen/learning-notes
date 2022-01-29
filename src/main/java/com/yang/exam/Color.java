package com.yang.exam;

import java.util.Scanner;

public class Color {

    static class TreeNode{
        int index;
        int color;
        TreeNode left;
        TreeNode right;

        public TreeNode(int i) {
            index = i;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            TreeNode treeNode = new TreeNode(nums[i]+1);
            int a = scanner.nextInt();
            int b = scanner.nextInt();

        }
    }
}
