package com.lxgzhw.demo04;

import java.util.ArrayList;

public class ArrayList07 {
    public static void main(String[] args) {
        //遍历4个学生的集合
        ArrayList<Student> students = new ArrayList<>();

        //添加学生
        students.add(new Student("楚枫", 22));
        students.add(new Student("萃萃", 22));
        students.add(new Student("大黄", 300));
        students.add(new Student("狌狌", 100000));

        //遍历学生集合
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }
}
