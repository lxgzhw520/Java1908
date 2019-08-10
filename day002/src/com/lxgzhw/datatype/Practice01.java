package com.lxgzhw.datatype;

public class Practice01 {
	public static void main(String[] args) {
		// 声明整型变量a并赋值为250
		int a = 250;
		// 声明整型变量b并赋值为100亿
		// int b=10000000000;
		// 输出5/2
		System.out.println("5/2=" + (5 / 2));
		// 输出2/5
		System.out.println("2/5=" + (2 / 5));
		// 输出2.0/5
		System.out.println("2.0/5=" + (2.0 / 5));
		// 声明整型变量c并赋值为2147483647(int最大值),并加1,然后输出
		int c = 2147483647;
		c += 1;
		System.out.println("c=" + c);
		// 常量长整型变量d并赋值为100亿
		long d = 10000000000L;
		long e = 1000000000 * 2 * 10L;
		long f = 1000000000 * 3 * 10L;
		long g = 1000000000L * 3 * 10;
		System.out.println("e=" + e);
		System.out.println("f=" + f);
		System.out.println("g=" + g);
		long h = System.currentTimeMillis();
		System.out.println("h=" + h);

		// 浮点型
		double pi = 3.14;
		double i = 6.0, j = 4.9;
		System.out.println("i+j=" + (i + j));
	}
}
