package com.yang.leetcode.editor.cn;

//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 797 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length - 1;
        int i = len;
        int j = len;
        while (i > 0 && nums[i-1] >= nums[i]){
            i--;
        }
        if (i <= 0){
            reverse(nums, i);
        }else{
            int left = i - 1;
            for (; j > left ; j--) {
                if (nums[j] > nums[left]){
                    swap(nums, j, left);
                    break;
                }
            }

            reverse(nums, i);
        }
    }

    private void swap(int[] nums, int i, int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

    private void reverse(int[] nums, int i){
        int start = i;
        int end = nums.length - 1;

        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

