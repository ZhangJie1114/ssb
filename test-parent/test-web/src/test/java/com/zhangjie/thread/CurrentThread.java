package com.zhangjie.thread;

public class CurrentThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//获取当前线程的引用
		Thread t = Thread.currentThread();
		System.out.println("当前线程：" + t);
		
		//设置线程名称
		t.setName("我的线程");
		System.out.println("修改名字后的线程：" + t);
		
		try{
			for(int n =5;n > 0;n--){
				System.out.println(n);
				//设置线程睡眠时间
				Thread.sleep(3000);
			}			
		}
		catch(InterruptedException e){
			System.out.println("线程被中断");
		}
	}

}
