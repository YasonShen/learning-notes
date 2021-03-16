package com.yang.test;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author shenqiuyang3
 * @date 2021/2/24 17:59
 * @Description
 */
public class NioTest {

    public static void main(String[] args) throws IOException {
        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel open = ServerSocketChannel.open();

    }
}
