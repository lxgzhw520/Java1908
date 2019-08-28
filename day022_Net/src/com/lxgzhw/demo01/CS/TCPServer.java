package com.lxgzhw.demo01.CS;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
服务器
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1.创建服务器并指定端口号ServerSocket
        ServerSocket ss = new ServerSocket(8888);
        //2.accept获取客户端对象 Socket
        Socket cs = ss.accept();
        //3.getInputStream获取网络字节输入流
        InputStream cis = cs.getInputStream();
        //4.使用字节输入流read方法读取客户端发送的数据
        byte[] bytes = new byte[1024];
        int len = cis.read(bytes);
        System.out.println(new String(bytes, 0, len));
        //5.getOutputStream获取网络字节输出流
        OutputStream cos = cs.getOutputStream();
        //6.使用字节输出流write方法写数据给客户端
        cos.write("机器人说:\n我终于会Java网络编程了.".getBytes());
        //7.释放资源
        ss.close();
        cs.close();
    }
}
