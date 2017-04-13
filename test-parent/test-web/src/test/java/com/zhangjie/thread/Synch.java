package com.zhangjie.thread;

class Synch {
	public static void main(String arg[]) {
		Callme target = new Callme();
		Caller ob1 = new Caller(target, "你好");
		Caller ob2 = new Caller(target, "同步");
		Caller ob3 = new Caller(target, "世界");

		try {
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		} catch (InterruptedException e) {
			System.out.println("线程中断");
		}
	}
}

class Callme {
	// void callme(String msg) {
	synchronized void callme(String msg) {
		System.out.println("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("线程中断");
		}
		System.out.println("]");
	}
}

class Caller implements Runnable {
	String msg;
	Callme target;
	Thread t;

	public Caller(Callme targ, String s) {
		target = targ;
		msg = s;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		// synchronized (target) {
		// target.callme(msg);
		// }
		target.callme(msg);
	}
}
