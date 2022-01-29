package com.yang.test;

import java.util.Arrays;

public class HeapSortTest {

    public static void main(String[] args) {
        int[] arr = {2, 4, 3 ,4,3,2,1,6,7};
        headSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void downAdjust(int[] arr, int parentIndex, int length){
        int temp = arr[parentIndex];
        int childIndex = parentIndex*2 + 1;

        while(childIndex < length){
            if(childIndex+1 < length && arr[childIndex+1] > arr[childIndex]){
                childIndex++;
            }
            if(temp >= arr[childIndex]){
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2*childIndex + 1;
        }

        arr[parentIndex] = temp;
    }

    private static void headSort(int[] arr){
        for(int i = (arr.length-2) / 2; i >= 0; i--){
            downAdjust(arr, i, arr.length);
        }
        for (int i = arr.length-1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            downAdjust(arr, 0, i);
        }
    }
}
