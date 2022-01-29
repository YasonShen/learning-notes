package com.yang.test;

public class IPToInt {

    public static void main(String[] args) {
        ipToInt("10.0.3.193");
        intToIP("167969729");
    }

    private static void ipToInt(String ip){
        String[] strs = ip.split("\\.");
        long[] a = new long[4];
        for (int i = 0; i < 4; i++){
            a[i] = Long.parseLong(strs[i]);
        }
        System.out.println(a[0] << 24 | a[1] << 16 | a[2] << 8 | a[3]);
    }

    private static void intToIP(String num){
        long d = Long.parseLong(num);
        String out = String.format("%d.%d.%d.%d", (d >> 24) & 0xff, (d >> 16) & 0xff, (d >> 8) & 0xff, d & 0xff);
        System.out.println(out);
    }
}
