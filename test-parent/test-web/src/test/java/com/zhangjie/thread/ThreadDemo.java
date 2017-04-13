package com.zhangjie.thread;

//实现Runnable接口，创建子线程
class NewThreads implements Runnable {
	Thread t;
	String name;

	NewThreads(String threadName) {
		name = threadName;
		t = new Thread(this, name);
		System.out.println("子线程名称：" + t);
		// 启动线程,即调用run()方法
		t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("子线程：" + name + i);
				// 设置线程睡眠时间
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("子线程中断" + name);
		}
		System.out.println("正在退出子线程" + name);
	}
}

class ThreadDemo {
	public static void main(String args[]) {
		// 创建一个子线程
		NewThreads nt1 = new NewThreads("我的子线程一");
		NewThreads nt2 = new NewThreads("我的子线程二");
		NewThreads nt3 = new NewThreads("我的子线程三");

		nt1.t.setPriority(10);
		System.out.println("线程优先级" + nt1.t.getPriority());

		// isAlive()方法获取线程是否结束
		System.out.println("子线程一" + nt1.t.isAlive());
		System.out.println("子线程二" + nt2.t.isAlive());
		System.out.println("子线程三" + nt3.t.isAlive());

		Thread t = Thread.currentThread();
		t.setName("我的主线程");
		System.out.println("主线程名称：" + t);
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("主线程：" + i);
				Thread.sleep(3000);

				// join()方法等待线程终止
				nt1.t.join();
				nt2.t.join();
				nt3.t.join();
			}
		} catch (InterruptedException e) {
			System.out.println("主线程中断");
		}
		// isAlive()方法获取线程是否结束
		System.out.println("子线程一" + nt1.t.isAlive());
		System.out.println("子线程二" + nt2.t.isAlive());
		System.out.println("子线程三" + nt3.t.isAlive());

		System.out.println("正在退出主线程");
	}
}