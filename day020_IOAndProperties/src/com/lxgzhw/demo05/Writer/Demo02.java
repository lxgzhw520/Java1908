package com.lxgzhw.demo05.Writer;

import java.io.FileWriter;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        //支持输出字符数组
        char[] arr = {'我', '是', '中', '国', '人'};
        FileWriter fileWriter = new FileWriter("test.txt");
        fileWriter.write(arr);
        fileWriter.close();
    }
}
