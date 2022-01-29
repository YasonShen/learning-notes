package com.yang.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSortedArray {

    /**
     * 方法一：
     *      不考虑复杂度的情况下，首先想到的方法是一次从两个数组中选取较小的那个，
     *      直到选取第k个，此种方法时间复杂度在O(k)，代码如下
     *
     * @param num1 数组1
     * @param num2 数组2
     * @param K  前k小元素
     * @return   返回元素值
     */
    public static int calc(int[] num1,int[] num2,int K){

        int ans = 0;
        int lidx = 0, ridx = 0;
        while (K>0){
            if (lidx<num1.length&&ridx<num2.length&&num1[lidx]>=num2[ridx]){
                ans = num2[ridx];
                ridx++;
                K--;
            }else if (lidx<num1.length&&ridx<num2.length&&num1[lidx]<num2[ridx]){
                ans = num1[lidx];
                lidx++;
                K--;
            }else if (lidx>=num1.length&&ridx<num2.length){
                ans = num2[ridx+K-1];
                break;
            }else if (ridx>=num2.length&&lidx<num1.length){
                ans = num1[lidx+K-1];
                break;
            }
        }
        return ans;


    }


    /**
     *  方法二：
     *        基于k/2数求解
     *        二分思想
     *        先比较num1数组的第k/2个和num2数组的第k/2个元素
     *        情况1：
     *          假如数组1的k/2下标元素 小于 数组2的k/2下标元素 那么说明，数组1的前k/2个元素在合并后数组前K个值里面
     *          此时我们已经找到了合并后数组的前k/2个值，剩下k/2个值在 数组1的【k/2，m】和数组2整个中去找
     *          因为a数组缩小，所以K值也缩小为K-k/2，但是这里的k/2不一定是K值的一半，有一种数组长度小于k/2的情况
     *          需要考虑，这时候我们将不再使用k/2而是数组的长度。
     *          以此产生递归思想，每次修改K为k/2即可，且数组的搜索范围也需要改。
     *        情况2：
     *          与情况一相反，假如数组1的k/2下标元素 大于 数组2的k/2下标元素
     *         时间复杂 o（log（n+m））
     *
     * @param num1
     * @param num2
     * @param K
     * @return
     */
    public static int calc2(int[] num1, int[] num2,  int K){
        //假定第一个数组长度小
        if (num1.length > num2.length){
            return calc2(num2,num1,K);
        }
        if (num1.length == 0){
            return num2[K-1];
        }
        if (K == 1){
            return Math.min(num1[0], num2[0]);
        }

        int len1 = num1.length;
        int len2 = num2.length;

        /* 如果两个数组大小不到k/2 取自身大小*/
        int x = Math.min(len1, K / 2);
        int y = Math.min(len2, K / 2);

        if (num1[x-1]>num2[y-1]){
            int[] newNum2 = Arrays.copyOfRange(num2, y, num2.length);
            return calc2(num1,newNum2,K-y);
        }else {
            int[] newNum1 = Arrays.copyOfRange(num1, x, num1.length);
            return calc2(newNum1,num2,K-x);
        }
    }

    /**
     *      不在去使用k/2作为标准，而是使用两个数组的 中位数 作为基准
     * 		第三方法思想太长了，就不阐述了，可以借鉴下面的博客，感谢这位同学的分析
     *      [思想来源](https://blog.csdn.net/lqglqglqg/article/details/48845225)
     *
     * @param num1
     * @param num2
     * @param K
     * @return
     */
    public  int calc3(int[] num1,int[] num2,int K) {
        if (num1.length == 0) {
            return num2[K - 1];
        }
        if (num2.length == 0) {
            return num1[K - 1];
        }
        if (K == 1) {
            return num1[K - 1] < num2[K - 1] ? num1[K - 1] : num2[K - 1];
        }
        //一奇一偶 转换为都是奇数，或者都是偶数
        if ((num1.length % 2 == 0 && num2.length % 2 != 0) || (num1.length % 2 != 0 && num2.length % 2 == 0)) {
            if (num1[0] < num2[0]) {
                int[] num1_C = Arrays.copyOfRange(num1, 1, num1.length);
                return calc3(num1_C, num2, K - 1);
            } else {
                int[] num2_C = Arrays.copyOfRange(num2, 1, num2.length);
                return calc3(num1, num2_C, K - 1);
            }
        }
        int num1Mid, num2Mid;
        //都是奇数
        if (num1.length % 2 != 0 && num2.length % 2 != 0) {
            num1Mid = num1.length / 2;
            num2Mid = num2.length / 2;
        } else { //都是偶数
            num1Mid = num1.length / 2 - 1;
            num2Mid = num2.length / 2;
        }

        if (num1[num1Mid] < num2[num2Mid]) {
            if (K <= num1Mid + num2Mid + 1) {
                int[] num2_C = Arrays.copyOfRange(num2, 0, num2Mid);
                return calc3(num1, num2_C, K);
            } else {
                int[] num1_C = Arrays.copyOfRange(num1, num1Mid + 1, num1.length);
                return calc3(num1_C, num2, K - num1Mid - 1);
            }
        } else {
            if (K <= num1Mid + num2Mid + 1) {
                int[] num1_C = Arrays.copyOfRange(num1, 0, num1Mid + 1);
                return calc3(num1_C, num2, K);
            } else {
                int[] num2_C = Arrays.copyOfRange(num2, num2Mid + 1, num2.length);
                return calc3(num1, num2_C, K - num2Mid - 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] A = {1,3,5,7,9};
        int[] B = {2,4,6,8,10};

        int res = calc(A, B, A.length+B.length-2);
        System.out.println(res);
    }
}
