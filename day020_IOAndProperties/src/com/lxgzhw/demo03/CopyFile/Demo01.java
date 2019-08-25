package com.lxgzhw.demo03.CopyFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //文件复制
        //test.txt  --->>>  test01.txt
        //1.创建输入流,绑定要复制的数据
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        //2.创建输出流,绑定复制到哪里
        FileOutputStream fileOutputStream = new FileOutputStream("test01.txt");
        //3.一次性读取多个字节
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            //4.进行复制
            fileOutputStream.write(bytes, 0, len);
        }
        //5.资源释放
        fileInputStream.close();
        fileOutputStream.close();
    }
}
