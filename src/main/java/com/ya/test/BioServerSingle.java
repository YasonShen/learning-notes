package com.ya.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServerSingle {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try{
            server = new ServerSocket(8082);
            while (true){
                socket = server.accept();
                inputStream = socket.getInputStream();
                int length = 0;
                byte[] req = new byte[1024];
                while ((length = inputStream.read(req)) > 0){
                    System.out.print(new String(req, 0, length));
                    outputStream = socket.getOutputStream();
                    outputStream.write("res".getBytes());
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (server != null){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
