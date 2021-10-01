package com.prateek.learning.dsa.rxjava.operators;

import com.prateek.learning.dsa.rxjava.Util;

import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Predicate;

public class UsingCount {

	public static void main(String args[]) {
		Util util = new Util();

		util.mObservableInt.takeUntil(new Predicate<Integer>() {

			@Override
			public boolean test(Integer arg0) throws Exception {
				System.out.println("takeUntil="+arg0);
				return arg0 > 6;
			}
		})
		.count().subscribe(new BiConsumer<Long, Throwable>() {

			@Override
			public void accept(Long arg0, Throwable arg1) throws Exception {
				System.out.println(arg0);
			}
		});
	}
}
