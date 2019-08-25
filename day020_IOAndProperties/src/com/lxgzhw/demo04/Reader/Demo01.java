package com.lxgzhw.demo04.Reader;

import java.io.FileReader;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //字符输入流
        //FileReader 按字符读取数据,FileInputStream是按字节读取
        //1.创建字符输入流
        FileReader fileReader = new FileReader("test.txt");
        //2.一次性读取多个字符
        char[] chars = new char[1024];
        int len = 0;
        while ((len = fileReader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
        //3.释放资源
        fileReader.close();
    }
}
