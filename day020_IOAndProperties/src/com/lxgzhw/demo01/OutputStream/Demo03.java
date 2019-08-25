package com.lxgzhw.demo01.OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo03 {
    public static void main(String[] args) throws IOException {
        //追加写FileOutputStream(位置,是否追加)
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        for (int i = 0; i < 10; i++) {
            //将字符串转换为字节数组后写入
            fileOutputStream.write("你好".getBytes());
            fileOutputStream.write("\r\n".getBytes());
        }
    }
}
