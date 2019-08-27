package com.lxgzhw.demo01.BufferedStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo04 {
    public static void main(String[] args) throws IOException {
        //字符缓冲输入流
        /*
        注意:
            1.依赖于FileReader
            2.判断是否读取完毕为null,不再是-1
            3.读取一行的方法是readLine,返回字符串
         */
        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
