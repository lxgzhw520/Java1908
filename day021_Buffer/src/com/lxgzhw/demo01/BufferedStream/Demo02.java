package com.lxgzhw.demo01.BufferedStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        //字节缓冲输入流
        /*
        注意:
            1.依赖于字节输入流
            2.读取的时候需要自己创建读取的大小数组
         */
        //1.创建字节缓冲输入流对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("test.txt"));
        //2.读取数据
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        //3.释放资源
        bufferedInputStream.close();
    }
}
