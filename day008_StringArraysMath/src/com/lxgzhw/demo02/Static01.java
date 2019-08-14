package com.lxgzhw.demo02;

public class Static01 {
    public static void main(String[] args) {
        Student cuiCui = new Student("萃萃", 19);
        Student cuFeng = new Student("楚枫", 19);

        //加入教室
        cuFeng.room = "101教室";
        //打印萃萃的教室
        //可以发现,教室是同一个教室
        //多个对象共享同一个数据
        System.out.println(cuiCui.room);
        System.out.println("-------------------------------");
        //打印学号
        //学号实现了自增
        System.out.println(cuFeng.getId());
        System.out.println(cuiCui.getId());
    }
}
