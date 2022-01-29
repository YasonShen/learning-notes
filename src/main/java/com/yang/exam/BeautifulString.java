package com.yang.exam;

import java.util.*;

public class BeautifulString {

    public static boolean permutation(String s) {
        List<String> ret = new ArrayList<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        do {
            ret.add(new String(arr));
        } while (nextPermutation(arr));
        int size = ret.size();
        for (int i = 0; i < size; i++) {
            if (isReverse(ret.get(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = arr.length - 1;
        while (j >= 0 && arr[i] >= arr[j]) {
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i + 1);
        return true;
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(char[] arr, int start) {
        int left = start, right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    static boolean isReverse(String s){
        if(s.length() == 1){
            return false;
        }
        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            if(s.charAt(left) != s.charAt(right)) {
                return true;
            }
            left++;
            right--;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        boolean tag = false;
        for (int i = 0; i < T; i++) {
            String s = scanner.nextLine();
            if (permutation(s)){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }

    }
}
