package com.yang.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NioServer {

    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        serverSocket.configureBlocking(false);
        System.out.println("服务启动成功");
//        Selector selector = Selector.open();
//        SelectionKey selectionKey = serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            //非阻塞模式accept()方法不会阻塞
            //NIO的非阻塞由操作系统内部实现，底层调用了Linux内核的accept函数
            SocketChannel socketChannel = serverSocket.accept();
            if (socketChannel != null){
                System.out.println("连接成功");
                socketChannel.configureBlocking(false);
                channelList.add(socketChannel);
            }
//            selector.select();
//            Set<SelectionKey> selectionKeys = selector.selectedKeys();
//            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            //遍历连接进行数据读取
            Iterator<SocketChannel> iterator = channelList.iterator();
            while (iterator.hasNext()){
                SocketChannel sc = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                int len = sc.read(byteBuffer);

                if (len > 0){
                    System.out.println("接受到消息："+new String(byteBuffer.array()));
                }else if (len == -1){
                    System.out.println("断开连接");
                }
            }
        }

    }
}
