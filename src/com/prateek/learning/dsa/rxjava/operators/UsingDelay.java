package com.prateek.learning.dsa.rxjava.operators;

import java.util.concurrent.TimeUnit;

import com.prateek.learning.dsa.rxjava.Util;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class UsingDelay {

	public static void main(String args[]) {
		Util util = new Util();

		util.mObservableInt.delay(1, TimeUnit.SECONDS).subscribe(util.mObserverInt);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
