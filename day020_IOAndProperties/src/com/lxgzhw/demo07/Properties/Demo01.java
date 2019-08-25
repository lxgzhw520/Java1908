package com.lxgzhw.demo07.Properties;

import java.io.*;
import java.util.Properties;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //Properties唯一和流结合的集合
        //load加载文件中的键值对
        //store保存键值对到文件
        /*
        1.支持#号注释
        2.键值对在内存中必须都是字符串
        3.在文件中无需引号
         */
        //1.创建集合
        Properties properties = new Properties();
        properties.setProperty("楚枫", "22");
        properties.setProperty("萃萃", "22");
        properties.setProperty("大黄", "322");
        //2.保存数据
        properties.store(new FileWriter("prop.txt"), "");
        System.out.println("数据保存成功.");
        //3.查看数据,读取数据
        Properties properties1 = new Properties();
        properties1.load(new FileReader("prop.txt"));
        System.out.println(properties1);
    }
}
