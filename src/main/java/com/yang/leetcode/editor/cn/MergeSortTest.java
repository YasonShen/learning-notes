package com.yang.leetcode.editor.cn;

import com.yang.test.QuickSortTest;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortTest {
    static int[] temp;
    public static void main(String[] args) {
        int[] nums = {4,2,1,3};
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));


    }

    private static void mergeSort(int[] nums, int l, int r){
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        int i = l, j = mid + 1;
        int cnt = 0;
        while(i <= mid && j <= r){
            if(nums[i] <= nums[j]){
                temp[cnt++] = nums[i++];
            }else{
                temp[cnt++] = nums[j++];
            }
        }

        while (i <= mid){
            temp[cnt++] = nums[i++];
        }
        while (j <= r){
            temp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = temp[k];
        }

    }

}
