package com.yang.leetcode.editor.cn;

public class RepeatedSubstringPattern {

    private boolean repeatedSubStringPattern(String s){

//        此方法对于"abaabb"这种类型的无效
//        char[] chars = s.toCharArray();
//        HashMap<Character, Integer> hashMap = new HashMap<>();
//
//        for (int i = 0; i < chars.length; i++) {
//            if (hashMap.containsKey(chars[i])){
//                Integer count = hashMap.get(chars[i]);
//                hashMap.put(chars[i], count+1);
//            }else{
//                hashMap.put(chars[i], 1);
//            }
//        }
//
//        Iterator<Map.Entry<Character, Integer>> iterator = hashMap.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<Character, Integer> next = iterator.next();
//        }
//
//        Integer temp = hashMap.get(s.charAt(0));
//        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
//            Integer value = entry.getValue();
//            if (value != temp) return false;
//        }
//        return true;

        String str = s + s;
        return str.substring(1, str.length()-1).contains(s);
    }

    public static void main(String[] args) {

    }
}
