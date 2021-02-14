package com.yang.test;

/**
 * @author shenqiuyang3
 * @date 2021/1/21 15:49
 * @Description
 */
public class MinPathSum {

    public int minPathSum (int[][] matrix) {
        // write code here
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int len = matrix[0].length + matrix.length - 1;
        int[] dp = new int[len];
        int i = 0, j = 0,index = 1;
        dp[0] = matrix[0][0];
        while(i < row && j < col){
            if(matrix[i+1][j] > matrix[i][j+1]){
                dp[index] = dp[index-1] + matrix[i][j+1];
                j++;
            }else{
                dp[index] = dp[index-1] + matrix[i+1][j];
                i++;
            }
            index++;
        }
        dp[index] = dp[index-1] + matrix[row][col];
        return dp[index];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}
        };

        int i = new MinPathSum().minPathSum(matrix);
        System.out.println(i);
    }
}
