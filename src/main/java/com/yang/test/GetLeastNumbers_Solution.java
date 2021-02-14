package com.yang.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author shenqiuyang3
 * @date 2021/1/14 15:39
 * @Description
 */
public class GetLeastNumbers_Solution {

    public ArrayList<Integer> getLeastNumbers(int [] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i = 0; i < input.length; i++){
            if (queue.size() != k){
                queue.offer(input[i]);
            }else if (queue.peek() > input[i]){
                queue.poll();
                queue.offer(input[i]);
            }
        }

        for(Integer integer : queue){
            list.add(integer);
        }

        return list;



    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        int k = 4;

        ArrayList<Integer> leastNumbers = new GetLeastNumbers_Solution().getLeastNumbers(input, k);

        Iterator<Integer> iterator = leastNumbers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
