package com.lxgzhw.demo01.File;

import java.io.File;
import java.io.IOException;

public class Demo05 {
    public static void main(String[] args) {
        //创建文件夹
        File root = new File("D:\\Java\\JavaTutorial\\Java1908\\day019_FileAndRecursion");
        File test = new File(root, "test");
        boolean mkdir = test.mkdir();
        if (mkdir) {
            System.out.println("创建文件夹成功");
        } else {
            System.out.println("创建文件夹失败");
        }
        System.out.println("-------------------------------");
        //创建文件
        File file = new File(root, "test\\test.txt");
        try {
            boolean newFile = file.createNewFile();
            if (newFile) {
                System.out.println("创建文件成功.");
            } else {
                System.out.println("创建文件失败.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------");
        //创建多级文件夹
        File file1 = new File(root, "test01\\test02\\test03");
        boolean mkdirs = file1.mkdirs();
        if (mkdirs) {
            System.out.println("创建多级目录成功.");
        } else {
            System.out.println("创建多级目录失败.");
        }

    }
}
