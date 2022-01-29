package com.yang.test;


import java.util.Scanner;

public class OS2 {

    public static void main(String[] args) {
        String cur = "linux:/sys/class/tty/console";
        String[] paths = cur.split("/");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String res = cur;
            String str = scanner.nextLine();
            if (str.equals("cd")){
                res = "linux:";
            }
            int flag = 0;
            int index = 4;
            if(str.length() > 4 && str.substring(0, 4).equals("cd .")){
                str = str.substring(3);
                str = removeRepeat(str);
                String[] strs = str.split("/");
                for (int i = 0; i < strs.length; i++) {
                    if (strs[i].equals("..")){
                        index--;
                    }else if(!strs[i].equals(paths[index+1])){
                        break;
                    }else{
                        index++;
                    }
                    if (i == strs.length-1)  flag = 1;
                }
            }
            if (flag == 1){
                if (index == 0){
                    res = "linux:";
                }else{
                    res = "";
                    for (int i = 0; i <= index ; i++) {
                        res = res+"/"+paths[i];
                    }
                }
            }
            System.out.println(res);
        }
    }

    private static String removeRepeat(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length()-1; i++) {
            char c = str.charAt(i);
            char nextC = str.charAt(i+1);
            if (c == nextC && c == '/'){
                continue;
            }else{
                sb.append(c);
            }
        }
        sb.append(str.charAt(str.length()-1));
        return sb.toString();
    }

}
