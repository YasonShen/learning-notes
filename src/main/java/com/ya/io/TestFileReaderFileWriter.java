package com.ya.io;


import org.junit.jupiter.api.Test;

import java.io.*;

public class TestFileReaderFileWriter {



    @Test
    public void testFileReader()  {

        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            fileReader = new FileReader(file);

            int data;
            while ((data = fileReader.read()) != -1){
                System.out.print((char)data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    @Test
//    public void testFileReaderFileWriter() throws IOException {
//        File srcFile = new File("hello.txt");
//        File destFile = new File("hello2.txt");
//
//        FileReader fr = new FileReader(srcFile);
//        FileWriter fw = new FileWriter(destFile);
//
//        char[] cbuf = new char[5];
//        int len;
//        while ((len = fr.read(cbuf)) != -1){
//            fw.write(cbuf, 0, len);
//        }
//
//        fw.close();
//        fr.close();
//    }
}
