package com.yang.test;

import java.util.Arrays;

/**
 * @author shenqiuyang3
 * @date 2020/12/28 10:56
 * @Description
 */
public class QuickSortTest {


    public static void main(String[] args) {

        int[] nums = {1, 4, 5, 2,3,2,2,32, 5, 23, 6, 12, 10};
        quickSort(nums, 0, 12);
//        new QuickSortTest().reverse(nums);
        System.out.println(Arrays.toString(nums));


    }

    private void reverse(int[] nums) {
        int i = 0;
        int len = nums.length - 1;
        while (i < len) {
            swap(nums, i, len);
            i++;
            len--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void quickSort(int[] nums, int i, int j){

        if (i >= j) return;
        int pos = findPos(nums, i, j);
        quickSort(nums, i,pos-1);
        quickSort(nums, pos+1, j);
    }

    private static int findPos(int[] nums, int i, int j){
        int key = nums[i];

        while (i < j){

            while (i < j && nums[j] >= key){
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= key){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[j] = key;

        return i;
    }

//    private static void quickSort(int[] nums, int i, int j) {
//        if (i >= j) return;
//
//        int pos = findPos(nums, i, j);
//        quickSort(nums, i, pos - 1);
//        quickSort(nums, pos + 1, j);
//    }
//
//    private static int findPos(int[] nums, int i, int j) {
//        int key = nums[i];
//        int l = i;
//        int r = j;
//
//        while (l < r) {
//
//            while (l < r && nums[r] >= key) {
//                r--;
//            }
//            nums[l] = nums[r];
//            while (l < r && nums[l] <= key) {
//                l++;
//            }
//            nums[r] = nums[l];
//        }
//        nums[l] = key;
//        return l;
//    }

}
