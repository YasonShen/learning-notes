package com.yang.test;

/**
 * @author shenqiuyang3
 * @date 2021/1/21 18:27
 * @Description
 */
public class FindKth {

    public int findKth(int[] a, int n, int K) {
        // write code here
        return findK(a, 0, n-1, K);
    }

    private int findK(int[] a, int low, int high, int K){
        int pos = findPos(a, low, high);
        if(high-pos+1 == K){
            return a[pos];
        } else if(high-pos+1 > K){
            return findK(a, pos+1, high, K);
        }else{
            return findK(a, low, pos, K-high+pos-1);
        }
    }

    private int findPos(int[] a, int l, int r){

        int key = a[l];

        while(l < r){
            while(l < r && a[r] >= key){
                r--;
            }
            a[l] = a[r];
            while(l < r && a[l] <= key){
                l++;
            }
            a[r] = a[l];
        }

        a[l] = key;
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,2,2,6,7,8,4};
        int n = 9, k = 3;
        int res = new FindKth().findKth(nums, n, k);
        System.out.println(res);
    }
}
