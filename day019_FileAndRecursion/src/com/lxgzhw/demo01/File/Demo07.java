package com.lxgzhw.demo01.File;

import java.io.File;

public class Demo07 {
    public static void main(String[] args) {
        //遍历文件夹 得到字符串
        File D = new File("D:\\");
        String[] dList = D.list();
        for (String s : dList) {
            System.out.println(s);
        }
        System.out.println("-------------------------------");
        //遍历文件夹 得到file对象
        File[] dFiles = D.listFiles();
        for (File dFile : dFiles) {
            System.out.println(dFile);
        }
    }
}
