package com.lxgzhw.demo02.InputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //字节输入流
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        //一次性读取
        int len = 0;
        while ((len = fileInputStream.read()) != -1) {
            System.out.println(len);
        }
        fileInputStream.close();
    }
}
