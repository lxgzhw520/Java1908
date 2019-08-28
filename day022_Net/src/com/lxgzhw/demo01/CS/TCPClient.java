package com.lxgzhw.demo01.CS;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
客户端
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.创建客户端对象 Socket
        Socket localhost = new Socket("127.0.0.1", 8888);
        //2.获取字节输出流getOutputStream
        OutputStream outputStream = localhost.getOutputStream();
        //3.向客户端发送数据
        //3.1 让用户输入数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入内容:");
        String next = sc.next();
        outputStream.write(next.getBytes());
        //4.获取字节输入流getInputStream
        InputStream inputStream = localhost.getInputStream();
        //5.读取服务器发送的数据
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));
        //6.释放资源
        localhost.close();
    }
}
