package com.lxgzhw.demo02.InputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        //一次性读取多个字节
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        fileInputStream.close();
    }
}
