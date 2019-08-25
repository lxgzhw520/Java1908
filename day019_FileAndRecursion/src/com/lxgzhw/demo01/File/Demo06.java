package com.lxgzhw.demo01.File;

import java.io.File;

public class Demo06 {
    public static void main(String[] args) {
        //删除文件
        File file = new File("test.txt");
        boolean delete = file.delete();
        if (delete) {
            System.out.println("删除文件成功.");
        } else {
            System.out.println("删除文件失败.");
        }
        System.out.println("-------------------------------");
        //删除文件夹
        //注意:只有空文件夹才能被删除
        File test = new File("test");
        boolean delete1 = test.delete();
        if (delete1) {
            System.out.println("删除文件夹成功.");
        } else {
            System.out.println("删除文件夹失败.");
        }
    }
}
