package com.lxgzhw.demo02.CopyFile;

import java.io.*;

public class Demo03 {
    public static void main(String[] args) throws IOException {
        //复制文件方法3:效率最高,推荐使用
        //使用字节缓冲输入输出流读写
        //1.创建读写缓冲字节流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("hzw.jpg"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("hzw03.jpg"));
        //2.读写
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }
        //3.关闭
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
