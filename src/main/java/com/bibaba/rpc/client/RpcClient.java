package com.bibaba.rpc.client;

import com.bibaba.rpc.server.RpcRequest;
import com.bibaba.rpc.server.RpcResponse;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * RpcClient
 * Rpc客户端，代表业务代码作为客户端，往远端服务发起请求。
 */
public class RpcClient {

    public Object start(RpcRequest request, String host, int port) throws Throwable {

        Socket server = new Socket(host, port);

        ObjectInputStream oin = null;
        ObjectOutputStream oout = null;

        try {
            // 1. 服务端输出流，写入请求数据，发送请求数据
            oout = new ObjectOutputStream(server.getOutputStream());
            oout.writeObject(request);
            oout.flush();

            // 2. 服务端输入流，获取返回数据，转换参数类型
            // 类似于反序列化的过程
            oin = new ObjectInputStream(server.getInputStream());
            Object res = oin.readObject();
            RpcResponse response = null;

            if (res instanceof RpcResponse) {
                throw new InvalidClassException("返回参数不正确，应当为：" + RpcResponse.class + " 类型");
            } else {
                response = (RpcResponse) res;
            }
            // 3. 返回服务端响应结果
            if (response.getError() != null) { // 服务器产生异常
                throw response.getError();
            }
            return response.getResult();
        } finally {
            try {    // 清理资源，关闭流
                if (oin != null) oin.close();
                if (oout != null) oout.close();
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
