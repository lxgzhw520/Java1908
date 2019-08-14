package com.lxgzhw.demo01;

public class Demo01 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        //调用父类的方法
        teacher.show();

        //助教类
        Assistant assistant = new Assistant();
        assistant.show();
    }
}
