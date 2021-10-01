package com.prateek.learning.dsa.rxjava.operators;

import com.prateek.learning.dsa.rxjava.Util;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class UsingFilterAndMap {

	public static void main(String args[]) {
		Util util = new Util();

		util.mObservableInt.filter(new Predicate<Integer>() {

			@Override
			public boolean test(Integer arg0) throws Exception {
				System.out.println("filter="+arg0);
				return arg0 % 2 == 0;
			}
		}).map(new Function<Integer, String>() {

			@Override
			public String apply(Integer arg0) throws Exception {
				System.out.println("apply="+arg0);
				return "10 times = "+(arg0 * 10);
			}
		}).subscribe(util.mObserverString);
	}
}
