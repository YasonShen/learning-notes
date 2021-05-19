//package com.bibaba.rpc.server;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.Executor;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//public class RpcServer {
//
//    /**
//     * 启动指定的网络端口号服务，并监听端口上的请求数据。获得请求数据以后将请求信息委派给服务处理器，放入线程池中执行。
//     * @param port 监听端口
//     * @param clazz 服务类所在包名，多个用英文逗号隔开
//     */
//    public void start(int port, String clazz) {
//        ServerSocket server = null;
//        try {
//            // 1. 创建服务端指定端口的socket连接
//            server = new ServerSocket(port);
//            // 2. 获取所有rpc服务类
//            Map<String, Object> services = getService(clazz);
//            // 3. 创建线程池
//            Executor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
//            while(true){
//                // 4. 获取客户端连接
//                Socket client = server.accept();
//                // 5. 放入线程池中执行
//                RpcServerHandler service = new RpcServerHandler(client, services);
//                executor.execute(service);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally{
//            //关闭监听
//            if(server != null)
//                try {
//                    server.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//        }
//    }
//
//}
