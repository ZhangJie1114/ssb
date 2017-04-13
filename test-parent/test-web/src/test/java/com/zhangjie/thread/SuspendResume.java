package com.zhangjie.thread;

public class SuspendResume {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		newThread ob1 = new newThread("One");
		newThread ob2 = new newThread("Two");

		try {
			Thread.sleep(1000);
			ob1.mysuspend();
			System.out.println("暂停 thread One");
			Thread.sleep(1000);
			ob1.myresume();
			System.out.println("恢复 thread One");
			ob2.mysuspend();
			Thread.sleep(1000);
			System.out.println("暂停 thread Two");
			Thread.sleep(1000);
			ob2.myresume();
			System.out.println("恢复 thread Two");
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		try {
			System.out.println("Waiting for threads to finish.");
			ob1.t.join();
			ob2.t.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		System.out.println("正在退出主线程");
	}
}

class newThread implements Runnable {
	String name;
	Thread t;
	boolean suspendFlag;

	newThread(String threadname) {
		name = threadname;
		t = new Thread(this, name);
		System.out.println("新的线程：" + t);
		suspendFlag = false;
		t.start();
	}

	public void run() {
		try {
			for (int i = 15; i > 0; i--) {
				System.out.println(name + "：" + i);
				Thread.sleep(1000);
				synchronized (this) {
					while (suspendFlag) {
						wait();
					}
				}
			}
		} catch (InterruptedException e) {
			System.out.println(name + "中断");
		}
		System.out.println(name + "正在退出");
	}

	synchronized void mysuspend() {
		suspendFlag = true;
	}

	synchronized void myresume() {
		suspendFlag = false;
	}
}
