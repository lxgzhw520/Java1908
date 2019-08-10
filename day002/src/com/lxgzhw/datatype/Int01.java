package com.lxgzhw.datatype;

public class Int01 {

	public static void main(String[] args) {
		// 1.整数直接量默认为int类型,不能超范围
		// 2.两个整数相除,小数部分直接舍弃,不会四舍五入
		// 3.整数运算时,若超出范围,则发生溢出(需要避免)
//		int salary=10000000000;//编译错误
		int salary = 100000000 * 1000;// 超过范围,不报错,溢出
		System.out.println("当前的工资是:" + salary);
	}

}
