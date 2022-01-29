package com.yang.exam;

public class Main8 {

    public static void main(String[] args) {

        int[] nums = {2,1,6,4,3,7};
        int i = partitionArray(nums);
        System.out.println(i);
    }


//    private static int partitionArray(int[] nums) {
//
//        int res = 0;
//
//        int n = nums.length;
//        // maxLeft[k] [0,k]之间的nums最大值
//        int[] maxLeft = new int[n];
//        // minRight[k] [k, n-1]的nums最小值
//        int[] minRight = new int[n];
//
//        int max = nums[0];
//        for (int i = 0; i < n; i++) {
//            if (nums[i] > max) {
//                max = Math.max(max, nums[i]);
//            }
//            maxLeft[i] = max;
//        }
//
//
//        int min = nums[n - 1];
//        for (int i = n - 1; i >= 0; i--) {
//            if (nums[i] < min) {
//                min = Math.min(min, nums[i]);
//            }
//            minRight[i] = min;
//        }
//
//
//        for (int i = 0; i < n - 1; i++) {
//            // 当左边最大值 <= 右边最小值  时可以进行切分
//            if (maxLeft[i] <= minRight[i + 1]) {
//                int j = i + 1;
//                System.out.println(i + " - " + j);
//
//                res++;
//            }
//        }
//
//        return res;
//    }

    public static int partitionArray(int[] nums) {
        int n = nums.length;
        int count = 1;

        int[] rightMin = new int[n];
        int[] leftMax = new int[n];

        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < rightMin[i + 1]) {
                rightMin[i] = nums[i];
            } else {
                rightMin[i] = rightMin[i + 1];
            }
        }

        leftMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > leftMax[i - 1]) {
                leftMax[i] = nums[i];
            } else {
                leftMax[i] = leftMax[i - 1];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                System.out.println(nums[i] + " -- " + nums[i + 1]);
                count++;
            }
        }

        return count;
    }

}
