package com.lxgzhw.datatype;

public class Int02 {

	public static void main(String[] args) {
		// 数据溢出案例演示
		int num = 2147483647;
		num += 1;
		System.out.println(num);

		num += 2;
		System.out.println(num);

		num += 3;
		System.out.println(num);
		
	}

}
