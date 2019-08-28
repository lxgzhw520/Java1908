package com.lxgzhw.demo02.Upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
文件上传服务器
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建服务器对象,并指定端口号ServerSocket
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.获取客户端对象 accept
        Socket accept = serverSocket.accept();
        //3.字节输入流 getInputStream
        InputStream inputStream = accept.getInputStream();
        //4.字节输出流 getOutputStream
        OutputStream outputStream = accept.getOutputStream();
        //5.读写文件,文件夹不存在要创建
        File file = new File("hzw01.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        //7.给客户端返回提示信息
        outputStream.write("上传成功".getBytes());
        //8.释放资源
        serverSocket.close();
        inputStream.close();
        outputStream.close();
    }
}
