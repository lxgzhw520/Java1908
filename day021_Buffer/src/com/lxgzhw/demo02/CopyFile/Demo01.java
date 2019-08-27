package com.lxgzhw.demo02.CopyFile;

import java.io.*;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //复制文件
        //方法1.使用字节输入输出流按字节复制
        //1.创建字节输入流
        InputStream inputStream = new FileInputStream("hzw.jpg");
        //2.创建字节输出流
        OutputStream outputStream = new FileOutputStream("hzw01.jpg");
        //3.输入流读取,输出流输出
        int len = 0;
        while ((len = inputStream.read()) != -1) {
            outputStream.write(len);
        }
        //4.释放
        inputStream.close();
        outputStream.close();
    }
}
