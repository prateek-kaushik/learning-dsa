package com.prateek.learning.dsa.rxjava.operators;

import java.util.concurrent.TimeUnit;

import com.prateek.learning.dsa.rxjava.Util;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class UsingDebounce {

	public static void main(String args[]) {
		Util util = new Util();

//		util.mObservableInt.debounce(1, TimeUnit.SECONDS).subscribe(util.mObserverInt);

		Observable<Long> observable = Observable.interval(2, TimeUnit.SECONDS);
		observable.debounce(1, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {

			@Override
			public void accept(Long arg0) throws Exception {
				System.out.println("accept::Long=" + arg0);
			}
		});
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
