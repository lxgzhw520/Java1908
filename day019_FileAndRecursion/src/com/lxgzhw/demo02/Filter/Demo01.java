package com.lxgzhw.demo02.Filter;

import java.io.File;

public class Demo01 {
    public static void main(String[] args) {
        //递归方法展示目录下所有文件
        File test01 = new File("test01");
        getFile(test01);
    }

    private static void getFile(File test01) {
        //1.调用listFiles
        File[] files = test01.listFiles();
        //2.遍历
        for (File file : files) {
            //3.判断是否为文件夹,是则递归调用
            if (file.isDirectory()) {
                System.out.println(file);
                System.out.print("\t--  ");
                getFile(file);
            } else {
                //否则打印
                System.out.println(file);
            }
        }
    }
}
