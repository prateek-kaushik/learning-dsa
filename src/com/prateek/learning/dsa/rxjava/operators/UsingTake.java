package com.prateek.learning.dsa.rxjava.operators;

import com.prateek.learning.dsa.rxjava.Util;

import io.reactivex.functions.Predicate;

public class UsingTake {
	public static void main(String args[]) {
		Util util = new Util();

		util.mObservableInt.take(5).subscribe(util.mObserverInt);

		util.mObservableInt.takeLast(7).subscribe(util.mObserverInt);

		util.mObservableInt.takeUntil(new Predicate<Integer>() {

			@Override
			public boolean test(Integer arg0) throws Exception {
				return arg0 > 6;
			}
		}).subscribe(util.mObserverInt);

		util.mObservableInt.takeWhile(new Predicate<Integer>() {

			@Override
			public boolean test(Integer arg0) throws Exception {
				return arg0 < 6;
			}
		}).subscribe(util.mObserverInt);
	}
}
