package com.lxgzhw.demo02.CopyFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        //复制文件方法2
        //使用输入输出流,每次读写一个字节数组
        //1.创建输入输出流
        FileInputStream fileInputStream = new FileInputStream("hzw.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("hzw02.jpg");
        //2.操作
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        //3.关闭
        fileInputStream.close();
        fileOutputStream.close();
    }
}
