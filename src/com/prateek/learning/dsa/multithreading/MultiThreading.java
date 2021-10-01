package com.prateek.learning.dsa.multithreading;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * Prints 1-10 using 2 threads in odd-even logic.
 *
 */
public class MultiThreading {

	private Thread mT1, mT2;
	int count = 1;
	boolean isOdd = true;
	Object mLock = new Object();

	public static void main(String[] args){
		MultiThreading obj = new MultiThreading();

		obj.mT1 = new Thread("Thread-1") {
			public void run() {
				while (obj.count <= 10) {
					obj.printOdd();
				}
			}
		};

		obj.mT2 = new Thread("Thread-2") {
			public void run(){
				while (obj.count <= 10) {
					obj.printEven();
				}
			}
		};

		obj.mT1.start();
		obj.mT2.start();
	}

	public void printOdd() {
		synchronized (mLock) {
			if (count < 10) {
				if (!isOdd) {
					try {
						mLock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + count);
				count++;
				isOdd = false;
				mLock.notify();
			}
		}
	}

	public void printEven() {
		synchronized (mLock) {
			if (count < 10) {
				if (isOdd) {
					try {
						mLock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + count);
				count++;
				isOdd = true;
				mLock.notify();
			}
		}
	}
}