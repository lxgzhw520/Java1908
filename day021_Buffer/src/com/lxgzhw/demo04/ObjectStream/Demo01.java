package com.lxgzhw.demo04.ObjectStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //写入自定义对象
        //需要用到的类 ObjectOutputStream
        //1.创建
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream("obj.txt"));
        //2.写入
        objectOutputStream.writeObject(new Person("楚枫", 22));
        //3.关闭
        objectOutputStream.close();
    }
}
