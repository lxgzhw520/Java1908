package com.lxgzhw.demo03.ReverseStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        //读取指定编码格式的文本
        //gbk
        readGBK();
        //utf8
        System.out.println("\n-------------------------------");
        readUTF8();
    }

    private static void readUTF8() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("utf8.txt"), "utf8");
        int len = 0;
        while ((len = inputStreamReader.read()) != -1) {
            System.out.print((char) len);
        }
        inputStreamReader.close();
    }

    private static void readGBK() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("gbk.txt"), "gbk");
        int len = 0;
        while ((len = inputStreamReader.read()) != -1) {
            System.out.print((char) len);
        }
        inputStreamReader.close();
    }
}
