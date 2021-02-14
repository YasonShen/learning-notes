package com.yang.test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SimpleFileTransferTest {

    private long transferFile(File source, File des) throws IOException{

        long startTime = System.currentTimeMillis();

        if (!des.exists()){
            des.createNewFile();
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(des));

//        将数据源读到的内容写入目的地--使用数组
        byte[] bytes = new byte[1024 * 1024];
        int len;
        while ((len = bufferedInputStream.read(bytes)) != -1){
            bufferedOutputStream.write(bytes, 0, len);
        }

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    private long transferFileWithNIO(File source, File des) throws IOException{
        long startTime = System.currentTimeMillis();

        if (!des.exists()) des.createNewFile();

        RandomAccessFile read = new RandomAccessFile(source, "rw");
        RandomAccessFile write = new RandomAccessFile(des, "rw");

        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);

        while (readChannel.read(byteBuffer) > 0){
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        writeChannel.close();
        readChannel.close();

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        SimpleFileTransferTest simpleFileTransferTest = new SimpleFileTransferTest();


    }
}
