package com.yang.netty;

import java.nio.ByteBuffer;

public class DirectMemoryTest {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1000);
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 200; j++) {
                buffer.putInt(j);
            }
            buffer.flip();
            for (int j = 0; j < 200; j++) {
                buffer.getInt();
            }
            buffer.clear();
        }
    }
}
