package com.lxgzhw.Set;

import java.util.HashSet;

/*
HashSet存储自定义类型:
    1.要求该类型重写hash方法和equals方法
 */
public class Demo03 {
    public static void main(String[] args) {
        //要求存储不同名字和年龄的对象
        HashSet<Person> people = new HashSet<>();
        people.add(new Person("楚枫", 23));
        people.add(new Person("楚枫", 23));
        people.add(new Person("萃萃", 23));
        people.add(new Person("萃萃", 23));
        people.add(new Person("大黄", 23));
        //遍历
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
