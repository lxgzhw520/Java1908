package com.lxgzhw.demo01.File;

import java.io.File;

public class Demo03 {
    public static void main(String[] args) {
        //常用方法

        //得到定义根路径
        File root = new File("D:\\Java\\JavaTutorial\\Java1908\\day019_FileAndRecursion");

        //拼接test.txt
        File test = new File(root, "test.txt");

        //打印文件长度
        System.out.println("文件长度:" + test.length());
        //打印文件路径
        System.out.println("文件路径:" + test.getAbsolutePath());
        System.out.println("文件路径:" + test.getPath());
        //打印上级文件夹
        System.out.println("上级文件夹:" + test.getParent());
        //打印文件名称
        System.out.println("文件名称:" + test.getName());

    }
}
