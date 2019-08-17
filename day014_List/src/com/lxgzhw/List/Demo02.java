package com.lxgzhw.List;

import java.util.LinkedList;

/*
LinkedList集合的特点:
    1.底层是链表,查询慢,增删快
    2.包含了大量操作首尾元素的方法
    3.不能使用多态
 */
public class Demo02 {
    public static void main(String[] args) {
        //添加方法
        linkedListAdd();
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        //删除方法
        linkedLIstRemove();
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        //其他方法
        linkedListEmpty();
    }

    //判断是否为空
    private static void linkedListEmpty() {
        //不为空就删除第一个元素
        LinkedList<String> strings = new LinkedList<>();
        if (!strings.isEmpty()) {
            System.out.println("不是空的...");
            strings.removeFirst();
        }
        System.out.println("是空的...");
    }

    //LinkedList集合的删除方法
    private static void linkedLIstRemove() {
        //1.removeFirst()
        //2.removeLast()
        //3.pop()
        //4.remove()
        LinkedList<String> strings = new LinkedList<>();
        strings.add("楚枫");
        strings.add("萃萃");
        strings.add("大黄");
        strings.push("第一个");
        strings.push("第一个");
        System.out.println(strings);
        System.out.println("-------------------------------");
        //pop removeFirst 删除第一个元素
        strings.removeFirst();
        strings.pop();
        System.out.println(strings);
        System.out.println("-------------------------------");
        strings.addLast("最后一个");
        System.out.println(strings);
        System.out.println("-------------------------------");
        //removeLast删除最后一个
        strings.removeLast();
        System.out.println(strings);
        System.out.println("-------------------------------");

    }

    //LinkedList增加方法
    private static void linkedListAdd() {
        //1.addFirst(元素) 将元素添加到开头
        //2.addLast(元素) 将元素添加到结尾
        //3.push(元素) 将元素添加到堆栈(开头)
        //总结: 开头 addFirst  push  结尾 add addLast
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        System.out.println(integers);
        System.out.println("-------------------------------");
        System.out.println("添加到结尾:");
        integers.addLast(33);
        integers.add(3333);
        System.out.println(integers);
        integers.push(333);
        System.out.println("-------------------------------");
        System.out.println("添加到开头");
        System.out.println(integers);
        integers.addFirst(33333);
        System.out.println(integers);
        System.out.println("-------------------------------");

    }
}
