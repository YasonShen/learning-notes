package com.yang.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;

public class NioSelectorServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        serverSocket.configureBlocking(false);

        Selector selector = Selector.open();
        SelectionKey selectionKey = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务启动成功");

        while (true){
            //阻塞等待需要处理的事件发生
            selector.select();
            //获取selector中注册的全部事件的SelectionKey实例
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            //遍历连接进行数据读取
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isAcceptable()){
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, selectionKey.OP_READ);
                    System.out.println("客户端连接成功");
                }else if(key.isReadable()){
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    int len = channel.read(byteBuffer);

                    //如果有数据，把数据打印出来
                    if (len > 0){
                        System.out.println("接受到消息："+new String(byteBuffer.array()));
                    }else if (len == -1){
                        System.out.println("断开连接");
                    }
                }

                //从事件集合中删除本次处理的key，防止下次select重复处理
                iterator.remove();
            }
        }

    }
}
