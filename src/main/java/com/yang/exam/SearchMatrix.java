package com.yang.exam;

public class SearchMatrix {

    private static boolean search(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m*n-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            int val = matrix[mid / n][mid % n];
            if (val < target){
                low = mid+1;
            }else if (val > target){
                high = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
        };
        int target = 15;
        System.out.println(search(matrix, target));

    }
}
