package com.lxgzhw.VarArgs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo02 {
    public static void main(String[] args) {
        //创建集合
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("楚枫", 22));
        people.add(new Person("萃萃", 18));
        people.add(new Person("大黄", 300));

        //按照年龄升序 o1-o2
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        //打印
        for (Person person : people) {
            System.out.println(person);
        }
        System.out.println("-------------------------------");
        //按照年龄降序 o2-o1
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        for (Person person : people) {
            System.out.println(person);
        }

    }
}
