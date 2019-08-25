package com.lxgzhw.demo01.OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        //一次写多个字节的方法
        byte[] arr = {97, 98, 99, 100, 101};
        //write(字节数组)
        fileOutputStream.write(arr);

        //write(字节数组,开始索引,长度)
        fileOutputStream.write(arr, 1, 3);

        fileOutputStream.close();
    }
}
