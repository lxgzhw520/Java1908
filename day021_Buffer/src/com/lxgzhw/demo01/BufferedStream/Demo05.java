package com.lxgzhw.demo01.BufferedStream;

import java.io.*;
import java.util.*;

public class Demo05 {
    public static void main(String[] args) throws IOException {
        //对文本内容进行排序
        //1.创建HashMap集合对象
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        //2.创建字符缓冲输入流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test01.txt"));
        //3.创建字符缓冲输出流
        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
        //4.使用输入流读取数据,按 .进行切割,存到集合中
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //切割
            String[] split = line.split("\\.");
            //5.对集合进行排序,HashMap会自动对key进行排序
            stringStringHashMap.put(split[0], split[1]);
        }
        //6.遍历集合,进行拼接,利用输出流写入
        for (String key : stringStringHashMap.keySet()) {
            String value = stringStringHashMap.get(key);
            line = key + "." + value;
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        //7.释放
        bufferedReader.close();
        bufferedWriter.close();
    }
}
