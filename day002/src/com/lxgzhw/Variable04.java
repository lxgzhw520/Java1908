package com.lxgzhw;

public class Variable04 {

	public static void main(String[] args) {
		// 1.变量的声明
		int a;
		int b, c, d;

		// 2.变量的初始化
		int age = 22;
		System.out.println("年龄是:" + age);
		int score;
		score = 99;
		System.out.println("分数是:" + score);

		// 3.变量的使用
		age = age + 1;
		System.out.println("他今年又长了一岁,现在的年龄是:" + age);
		score = score - 10;
		System.out.println("老师很不开心,决定扣10分,他现在的分数是:" + score);
	}

}
