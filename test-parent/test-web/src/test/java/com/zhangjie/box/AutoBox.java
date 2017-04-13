package com.zhangjie.box;

public class AutoBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 自动装箱，整型
		Integer iOb = 100;
		// 自动拆箱，整型
		System.out.println(iOb);
		// 拆箱，整型
		int i = iOb;
		System.out.println(i);
		
		// 自动装箱，布尔型
		Boolean b = true;
		// 自动拆箱，布尔型
		System.out.println(b);
		
		// 自动装箱，字符型
		Character ch = 'C';
		// 拆箱，字符型
		char ch2 = ch;
		System.out.println(ch2);
	}

}
