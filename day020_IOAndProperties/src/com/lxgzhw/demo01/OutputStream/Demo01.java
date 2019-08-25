package com.lxgzhw.demo01.OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //字节输出流
        //常用方法: close flush write
        //1.创建FileOutputStream对象
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        //2.调用write方法
        fileOutputStream.write(97);
        //3.释放资源
        fileOutputStream.close();
    }
}
