package com.prateek.learning.dsa.rxjava.operators;

import com.prateek.learning.dsa.rxjava.Util;

import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Predicate;

public class UsingContains {

	public static void main(String args[]) {
		Util util = new Util();

		util.mObservableInt.contains(11).subscribe(new BiConsumer<Boolean, Throwable>() {

			@Override
			public void accept(Boolean arg0, Throwable arg1) throws Exception {
				System.out.println("accept::arg0=" + arg0);
			}
		});
	}
}
