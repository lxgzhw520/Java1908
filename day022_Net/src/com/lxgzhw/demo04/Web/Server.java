package com.lxgzhw.demo04.Web;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
浏览器版本的服务器
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建一个服务器对象 ServerSocket
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.让服务器一直监听请求
        while (true) {
            //3.获取客户端对象
            Socket accept = serverSocket.accept();
            //4.开启多线程提升效率
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //线程任务:处理浏览器请求
                    try {
                        //5.获取网络字节输入流,转换为字符缓冲输入流
                        InputStream inputStream = accept.getInputStream();
                        BufferedReader bufferedReader =
                                new BufferedReader(new InputStreamReader(inputStream));
                        //6.读取客户端信息的第一行
                        String firstLine = bufferedReader.readLine();
                        //7.从客户端信息中提取信息
                        String htmlPath = firstLine.split(" ")[1].substring(1);
                        //8.创建本地字节输入流
                        FileInputStream fileInputStream = new FileInputStream(htmlPath);
                        //9.获取网络字节输出流
                        OutputStream outputStream = accept.getOutputStream();
                        //10.写HTTP协议响应头
                        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                        outputStream.write("Content-Type:text/html\r\n".getBytes());
                        //11.写空行
                        outputStream.write("\r\n".getBytes());
                        //12.读写html文件
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = fileInputStream.read(bytes)) != -1) {
                            outputStream.write(bytes, 0, len);
                        }
                        //13.释放资源
                        fileInputStream.close();
                        outputStream.close();
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
