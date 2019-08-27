package com.lxgzhw.demo01.BufferedStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo03 {
    public static void main(String[] args) throws IOException {
        //字符缓冲输出流
        /*
        注意:
            1.带Stream的是字节流,writer和reader是字符流
            2.换行有newline方法
         */
        //1.创建流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));
        //2.写入
        for (int i = 0; i < 10; i++) {
            bufferedWriter.write("理想国真恵玩");
            bufferedWriter.newLine();
        }
        //3.释放
        bufferedWriter.close();
    }
}
