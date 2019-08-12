package com.lxgzhw;

public class StudentTest {
    public static void main(String[] args) {
        //学生类的测试类
        //创建学生类
        Student sunWuKong = new Student("孙悟空", 22, "花果山");
        System.out.println(sunWuKong);
        sunWuKong.sayHi();
        sunWuKong.study();
    }
}
