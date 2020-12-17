package com.ya.leetcode.editor.cn;

public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;

        while (row < rows && column >= 0){
            if (matrix[row][column] == target){
                return true;
            }else if(matrix[row][column] < target){
                row++;
            }else{
                column--;
            }
        }

        return false;
    }
}
