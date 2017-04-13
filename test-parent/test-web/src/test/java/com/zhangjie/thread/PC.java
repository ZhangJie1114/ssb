package com.zhangjie.thread;

public class PC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		
		System.out.println("Press Control-C to stop.");
	}	
}

class Q{
	int n;
	boolean valueSet = false;
	
	synchronized int get(){
		while(!valueSet){
			try{
				//挂起线程
				wait();
			}catch	(InterruptedException e){
				System.out.println("InterruptedException caught" );
			}
		}
		System.out.println("Got：" + n);
		valueSet = false;
		//恢复线程
		notify();
		return n;
	}
	synchronized void put(int n){
		while(valueSet){
			try{
				//挂起线程
				wait();
			}catch(InterruptedException e){
				System.out.println("InterruptedException caught" );
			}
		}
		this.n = n;
		valueSet = true;
		System.out.println("Put：" + n);
		//恢复线程
		notify();
	}
}

class Producer implements Runnable{
	Q q;
	
	Producer(Q q){
		this.q = q;
		new Thread(this, "Producer").start();
	}
	
	public void run(){
		int i = 0;
		while (true) {
			q.put(i++);
		}
	}
}

class Consumer implements Runnable{
	Q q;
	
	Consumer(Q q){
		this.q = q;
		new Thread(this, "Consumer").start();
	}
	
	public void run(){
		while (true) {
			q.get();			
		}
	}
}