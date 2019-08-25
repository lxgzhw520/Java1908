package com.lxgzhw.demo05.Writer;

import java.io.FileWriter;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //字符输出流
        //支持直接输出字符串
        FileWriter fileWriter = new FileWriter("test.txt");
        fileWriter.write("直接输出字符串");
        fileWriter.close();
    }
}
