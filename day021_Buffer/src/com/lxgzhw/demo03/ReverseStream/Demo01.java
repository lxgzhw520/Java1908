package com.lxgzhw.demo03.ReverseStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //输出指定编码格式的文本
        //gbk
        writeGBK();
        //utf-8
        writeUTF8();
    }

    private static void writeUTF8() throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("utf8.txt"), "utf-8");
        outputStreamWriter.write("utf8格式的字符串");
        outputStreamWriter.close();
    }

    private static void writeGBK() throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("gbk.txt"), "gbk");
        outputStreamWriter.write("GBK格式的字符串");
        outputStreamWriter.close();
    }
}
