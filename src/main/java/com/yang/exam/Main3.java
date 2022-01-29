package com.yang.exam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        int[] nums = new int[words.length];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(words[i]);
        }
        int res = solveOne(nums);

        System.out.println(res);
    }


    private static int solveOne(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length;) {
            Set<Integer> set = new HashSet<>();
            int j = i;
            while (j < nums.length){
                if (set.add(nums[j])){
                    j++;
                }else{
                    break;
                }
            }
            ans++;
            i = j;
        }
        return ans;
    }
}
