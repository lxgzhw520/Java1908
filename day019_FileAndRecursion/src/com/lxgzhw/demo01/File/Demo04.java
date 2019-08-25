package com.lxgzhw.demo01.File;

import java.io.File;

public class Demo04 {
    public static void main(String[] args) {
        //判断方法
        File test = new File("test.txt");
        System.out.println("绝对路径:" + test.getAbsolutePath());

        //是否存在
        System.out.println("是否存在:" + test.exists());

        //是否为目录
        System.out.println("是否为目录:" + test.isDirectory());

        //是否为文件
        System.out.println("是否为文件:" + test.isFile());

        //是否为隐藏
        System.out.println("是否隐藏:" + test.isHidden());
    }
}
