package com.lxgzhw.demo01.BufferedStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //字符缓冲输出流
        /*
        注意:
            1.字节缓冲输出流需要依赖于字节输出流
            2.缓冲类似于传了一个数组,即就是同时传多个字节
            3.关闭的时候会自动调用刷新缓冲的flush功能
         */
        //1.创建
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("test.txt"));
        //2.输出
        bufferedOutputStream.write("字节缓冲输出流".getBytes());
        //3.释放资源
        bufferedOutputStream.close();
    }
}
