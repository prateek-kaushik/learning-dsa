package com.prateek.learning.dsa.rxjava.operators;

import com.prateek.learning.dsa.rxjava.Util;

import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Predicate;

public class UsingAll {

	public static void main(String args[]) {
		Util util = new Util();

		util.mObservableInt.all(new Predicate<Integer>() {

			@Override
			public boolean test(Integer arg0) throws Exception {
				System.out.println("test::arg0=" + arg0);
				return arg0 < 11;
			}
		}).subscribe(new BiConsumer<Boolean, Throwable>() {

			@Override
			public void accept(Boolean arg0, Throwable arg1) throws Exception {
				System.out.println("accept::arg0=" + arg0);
			}
		});
	}
}
