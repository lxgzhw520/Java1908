package com.lxgzhw.datatype;

public class Long02 {
	public static void main(String[] args) {
		// int和long类型进行运算,自动转换为long类型
		int salary = 1000000000;
		long num = 1000L;
		long result = salary * num;
		System.out.println(result);
	}
}
