package com.lxgzhw.demo03.Upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
多线程文件上传:服务器
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建服务器 ServerSocket
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.一直监听客户端上传
        while (true) {
            //3.获取客户端对象 accept
            Socket accept = serverSocket.accept();
            //4.多线程处理文件上传,来一个开启一个新线程
            new Thread(new Runnable() {
                @Override
                public void run() {

                    //线程任务:完成文件的上传
                    try {
                        //5.保存在upload文件夹
                        File upload = new File("upload");
                        //5.1判断文件夹是否存在
                        if (!upload.exists()) {
                            //5.2不存在则创建
                            upload.mkdir();
                        }
                        //5.自定义文件的命名规则
                        //5.1 规则:域名+毫秒值+随机数
                        String fileName = "lxgzhw" + System.currentTimeMillis()
                                + new Random().nextInt(999999) + ".jpg";
                        //6.创建本地字节输出流,获取网络字节输入流
                        FileOutputStream fileOutputStream =
                                new FileOutputStream(upload + "\\" + fileName);
                        InputStream inputStream = accept.getInputStream();
                        //7.读写文件
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = inputStream.read(bytes)) != -1) {
                            fileOutputStream.write(bytes, 0, len);
                        }
                        //8.将结果通知客户端
                        accept.getOutputStream().write("上传成功".getBytes());

                        //9.释放资源
                        fileOutputStream.close();
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }
}
