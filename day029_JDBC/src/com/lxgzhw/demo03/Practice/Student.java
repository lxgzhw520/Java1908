package com.lxgzhw.demo03.Practice;

import java.util.Date;

public class Student {
    //id name age math english chinese birthday insert_time
    private int id;
    private String name;
    private int math;
    private int english;
    private int chinese;
    private Date birthday;
    private Date insert_time;

    public Student() {
    }

    public Student(int id, String name, int math, int english, int chinese, Date birthday, Date insert_time) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.english = english;
        this.chinese = chinese;
        this.birthday = birthday;
        this.insert_time = insert_time;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", math=" + math +
                ", english=" + english +
                ", chinese=" + chinese +
                ", birthday=" + birthday +
                ", insert_time=" + insert_time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getInsert_time() {
        return insert_time;
    }

    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }
}
