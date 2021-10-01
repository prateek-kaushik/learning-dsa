package com.prateek.learning.dsa.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {

	public static void main(String args[]) {
		Semaphore sem = new Semaphore(1);

		Thread t1 = new MyThread("A", sem);
		Thread t2 = new MyThread("B", sem);

		t1.start();
		t2.start();

		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("final count value = " + SharedClass.count);
	}

	static class MyThread extends Thread {
		Semaphore sem;

		public MyThread(String name, Semaphore sem) {
			setName(name);
			this.sem = sem;
		}

		public void run() {
			try {
				sem.acquire();

				if (getName().equals("A")) {
					for (int i = 0; i < 5; i++) {
						SharedClass.count++;
						System.out.println(getName() + " - " + SharedClass.count);
						Thread.sleep(100);
					}
				} else {
					for (int i = 0; i < 5; i++) {
						SharedClass.count--;
						System.out.println(getName() + " - " + SharedClass.count);
						Thread.sleep(100);
					}
				}

				sem.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static class SharedClass {
		static int count = 0;
	}
}
