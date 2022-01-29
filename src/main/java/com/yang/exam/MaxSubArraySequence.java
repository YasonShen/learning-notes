package com.yang.exam;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shenqiuyang
 */
public class MaxSubArraySequence {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        getMaxLine(arr);
    }

    //获取数组中连续最大子序列 即子序列和最大 并且输出最大和
    public static void getMaxLine(int[] arry) {
        boolean flag = false;
        for (int i = 0; i < arry.length; i++) {
            if (arry[i] > 0) {
                flag = true;
            }
        }
        if (flag) {
            //当数组中存在正数的时候和最大默认maxSum
            int maxSum = 0;
            //创建第一个数组元素起始的所有相连子数组的和
            int[] sum = new int[arry.length];
            int i = 0;
            while (i < arry.length) {
                //System.out.println("arry["+i+"]="+arry[i]);
                if (i == 0) {
                    sum[i] = arry[0];
                } else {
                    sum[i] = sum[i - 1] + arry[i];
                }
                i++;
            }
            //求出sum[]数组中最大值
            int maxIndex = getMaxN(sum, sum.length);
            //求出sum[]数组中最大值下标之前的最小值
            int minIndex = getMinN(sum, maxIndex + 1);
            System.out.print("最大子序列为：");
            //输出最大子序列
            for (int j = minIndex + 1; j < maxIndex + 1; j++) {
                maxSum += arry[j];
                System.out.print(arry[j]);
            }
            System.out.println("");
            //"最大子序列的和为："+
            System.out.println("数组中的最大子序列的和为为：" + maxSum);
        } else {
            //当数组中没有正数的时候 相邻的子序列相加不会变大 所有就直接输出数组中最大的元素即最大子序列
            int index = getMaxN(arry, arry.length);
            System.out.println("数组中的最大子序列为：" + arry[index]);
            System.out.println("数组中的最大子序列的和为为：" + arry[index]);
        }


    }


    //求数组中前n个数中的最大数
    public static int getMaxN(int arry[], int n) {
        int max = arry[0];
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (arry[i] > max) {
                max = arry[i];
                index = i;
            }

        }
        return index;

    }

    //求数组中前n个数中的最小数
    public static int getMinN(int[] arry, int n) {
        int min = arry[0];
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (arry[i] < min) {
                min = arry[i];
                index = i;
            }
        }
        return index;

    }
}
