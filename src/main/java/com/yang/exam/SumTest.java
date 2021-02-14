package com.yang.exam;

public class SumTest {

    public static int qiuSum(int[] nums){

        int len = nums.length;
        int sum = nums[0] + nums[len - 1];
        int res = 0;

        for (int i = 0; i <= len / 2; i++){

            int temp = nums[i] + nums[len - i - 1];
            if (temp != sum){
                if (nums[len/2] + nums[len/2 - 1] == sum){
                    res = sum - nums[len - i - 1];
                }else {
                    res = sum - nums[i];
                }
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9,4,5,2,8,3,5,6,1};
        System.out.println(qiuSum(nums));
    }
}
