package com.prateek.learning.dsa.rxjava.operators;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.prateek.learning.dsa.rxjava.Util;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class UsingFlatMap {

	public static void main(String args[]) {
		Util util = new Util();

		util.mObservableInt.flatMap(new Function<Integer, Observable<String>>() {

			@Override
			public Observable<String> apply(Integer arg0) throws Exception {
				System.out.println("flatMap::apply::Integer=" + arg0);
				return Observable.just("flatmap-" + arg0).delay(2, TimeUnit.SECONDS);
			}
		}).subscribe(util.mObserverString);

//		util.mObservableInt.map(new Function<Integer, String>() {
//
//			@Override
//			public String apply(Integer arg0) throws Exception {
//				System.out.println("map::apply::Integer=" + arg0);
//				return "map-" + arg0;
//			}
//		}).subscribe(util.mObserverString);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
