package com.yang;

import java.util.Scanner;

public class OSCd {
    private static final String root = "linux:/sys/class/tty/console";

    public static void main(String[] args) {
        String[] roots = root.split("/");
        int len = roots.length;
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strs = line.split(" ");
        if (strs.length == 1) {
            System.out.println(root);
            return;
        } else {
            if (strs[1] == "..") {
                System.out.println("linux:/sys/class/tty");
                return;
            }
            String[] ss = strs[1].split("/");
            int sLen = ss.length;
            if (sLen == 1) {
                System.out.println(root);
                return;
            }
            int cnt = 0;
            for (int i = 0; i < ss.length; i++) {
                if (!"..".equals(ss[i])) {
                    break;
                }
                if ("..".equals(ss[i])) {
                    cnt++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len - cnt; i++) {
                sb.append(roots[i]).append("/");

            }
            for (int i = len - cnt; i < len; i++) {
                if (sLen == cnt) {
                    break;
                }
                if (cnt < ss.length && roots[i].equals(ss[cnt++])) {
                    if (i == len - 1) {
                        sb.append(roots[i]);
                    } else {
                        sb.append(roots[i]).append("/");
                    }
                } else {
                    System.out.println(root);
                    return;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
