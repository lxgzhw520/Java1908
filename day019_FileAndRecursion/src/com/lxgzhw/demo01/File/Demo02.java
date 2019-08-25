package com.lxgzhw.demo01.File;

import java.io.File;

public class Demo02 {
    public static void main(String[] args) {
        //创建文件对象

        //方法1:直接传路径
        File file = new File("D:\\Java\\JavaTutorial\\Java1908\\day019_FileAndRecursion\\test.txt");

        //方法2:两个路径拼接
        File file02 = new File("D:\\Java\\JavaTutorial\\Java1908\\day019_FileAndRecursion","test.txt");

    }
}
