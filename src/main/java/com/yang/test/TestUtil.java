package com.yang.test;


import java.util.*;

/**
 * @author shenqiuyang3
 * @date 2020/10/29 15:08
 */
public class TestUtil {

    public static void main(String[] args) {

        int[][] map = new int[][] {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
        };;
        System.out.println(map.length);
        System.out.println(map[0].length);
//        空集合可以进行流操作，null不行
        List<String> list = new ArrayList<>();
//        list = null;
        list.stream().forEach(s -> {
            System.out.println(s);
        });


        char[] chars = new char[]{'a', 'b', 'c'};
        System.out.println(String.valueOf(chars));

        String s = "abcd";

        String s2 = "abc sj sdk";
        StringBuilder sb = new StringBuilder(s2);
        StringBuilder reverse = sb.reverse();
        String[] s1 = s2.split(" ");

//        int[] b = new int[]{2,3,5};
//        int[] a = new int[b.length+1];
//        System.arraycopy(b,0,a,0,b.length);
//
//        String aaa = "storage.com.local//";
//
//        String replace = aaa.replace("com", "tt");
//        System.out.println( replace);
//
//        a[b.length] = 6;
//        System.out.println(Arrays.toString(a));
//
//        int[] ints = new int[4];
//        List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
//        List list1 = CollectionUtils.arrayToList(ints);
//
//        Iterator iterator = list1.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
    }
}
