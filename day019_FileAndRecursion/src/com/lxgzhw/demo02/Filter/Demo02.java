package com.lxgzhw.demo02.Filter;

import java.io.File;

public class Demo02 {
    public static void main(String[] args) {
        //查看以.java结尾的文件并打印
        File test01 = new File("test01");
        getJavaFile(test01);
    }

    private static void getJavaFile(File test01) {
        //1.调用listFiles
        File[] files = test01.listFiles();
        //2.遍历
        for (File file : files) {
            //3.判断是否为文件夹,不为空继续遍历
            if (file.isDirectory()) {
                getJavaFile(file);
            } else {
                //否则判断是否为.java结尾
                if (file.toString().toLowerCase().endsWith(".java")) {
                    System.out.println(file);
                }
            }
        }
    }
}
