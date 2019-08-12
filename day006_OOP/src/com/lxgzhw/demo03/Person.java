package com.lxgzhw.demo03;

/*
定义年龄时,无法阻止不合理的信息被设置进来
用private关键字将需要保护的成员变量进行修饰

一旦使用private进行修饰,那么本类当中仍然可以随意访问,
但是,本类范围之外就不能直接访问了
 */
public class Person {
    private String name;//姓名
    private int age;//年龄

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        //对不合理的年龄进行过滤
        if (age < 0) {
            System.out.println("不合理的年龄,年龄不能为负数.");
            //将年龄设为默认值0
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public void show() {
        System.out.println("我叫:" + this.name + "我" + this.age + "岁了.");
    }
}
