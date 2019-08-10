package com.lxgzhw.datatype;

public class Long03 {
	public static void main(String[] args) {
		// 计算一年所用的毫秒数
		long year = 365 * 60 * 60 * 24;
		System.out.println("去年今天到今年今天的毫秒数为:" + year);

		// 计算1970年1月1日零点到现在的毫秒数
		long now = System.currentTimeMillis();
		System.out.println("1970年1月1日零点到现在的毫秒数为:" + now);
	}
}
