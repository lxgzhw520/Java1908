package com.lxgzhw.demo03.Upload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //1.创建字节输入流对象 FileInputStream
        FileInputStream fileInputStream = new FileInputStream("hzw.jpg");
        //2.创建客户端对象 Socket
        Socket socket = new Socket("127.0.0.1", 8888);
        //3.获取客户端的输出流对象 getOutputStream
        OutputStream outputStream = socket.getOutputStream();
        //4.读取本地文件,用输出流写入
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        //5.通知客户端上传完毕,关闭输出流
        socket.shutdownOutput();
        //6.使用网络字节输入流读取服务器返回的数据
        InputStream inputStream = socket.getInputStream();
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        //7.释放资源
        fileInputStream.close();
        socket.close();
        outputStream.close();
        inputStream.close();
    }
}
