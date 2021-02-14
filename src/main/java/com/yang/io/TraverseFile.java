package com.yang.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shenqiuyang3
 * @date 2020/11/25 15:27
 */
public class TraverseFile {


    public static List<String> read(String APath) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(APath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = "";
        List<String> list = new ArrayList<>();

        while ((s = bufferedReader.readLine()) != null){
            s = s.replace("\"", "");
            list.add(s);
        }

        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        return list;
    }

    public static void writer(String BPath, List<String> list) throws IOException{

        FileOutputStream fileOutputStream = new FileOutputStream(BPath, true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        for (int i = 0; i < list.size(); i++) {
            bufferedWriter.write(list.get(i));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        System.out.println("写入结束了");
    }
}
