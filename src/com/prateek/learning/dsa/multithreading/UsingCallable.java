package com.prateek.learning.dsa.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UsingCallable {

	ExecutorService mExecService;
	Random mRandom;

	public int generateRandomNumber() {
		return mRandom.nextInt();
	}

	public static void main(String args[]) {
		UsingCallable callable = new UsingCallable();
		callable.mExecService = Executors.newFixedThreadPool(2);
		callable.mRandom = new Random();

		Callable<Integer> call1 = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				return callable.generateRandomNumber();
			}
		};
		
		Callable<Integer> call2 = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				return callable.generateRandomNumber();
			}
		};
		
		Future<Integer> f1 = callable.mExecService.submit(call1);
		Future<Integer> f2 = callable.mExecService.submit(call2);
		
		try {
			System.out.println(f1.get());
			System.out.println(f2.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		callable.mExecService.shutdown();
	}
}
