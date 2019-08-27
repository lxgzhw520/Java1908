package com.lxgzhw.demo04.ObjectStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Demo02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
        依赖类:
            ObjectInputStream
        读取方法:
            readObject()
        注意:
            1.必须存在该对象的字节码文件.class
            2.该类必须实现Serializable接口
         */
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("obj.txt"));
        Object o = objectInputStream.readObject();
        System.out.println(o);
        Person o1 = (Person) o;
        System.out.println(o1.getName() + ":" + o1.getAge());
    }
}
