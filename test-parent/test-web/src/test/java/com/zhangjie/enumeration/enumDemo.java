package com.zhangjie.enumeration;

public class enumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple ap;
		System.out.println("Here are all Apple constants：");
		
		//使用values()
//		Apple allapples[] = Apple.values();
		for(Apple a : Apple.values()){
			System.out.println(a);
		}
		System.out.println();
		
		//使用valueOf()
		ap = Apple.valueOf("Winesap");
		System.out.println("ap contains" + ap);
	}

}
enum Apple{
	Jonethan,GoldenDel,RedDel,Winesap,Cortland
}