package com.lxgzhw.demo03;

public class StudentTest01 {
    public static void main(String[] args) {
        Student cuFeng = new Student();
        cuFeng.setName("楚风");
        cuFeng.setAge(24);
        cuFeng.setMale(true);


        //姓名
        System.out.println("姓名: " + cuFeng.getName());
        //年龄
        System.out.println("年龄: " + cuFeng.getAge());
        //是否为男
        System.out.println("是否为男: " + cuFeng.isMale());
    }
}
