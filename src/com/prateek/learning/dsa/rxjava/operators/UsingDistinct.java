package com.prateek.learning.dsa.rxjava.operators;

import com.prateek.learning.dsa.rxjava.Util;

public class UsingDistinct {

	public static void main(String args[]) {
		Util util = new Util();

		util.mObservableInt
		.repeat(20)
		.distinct()
		.subscribe(util.mObserverInt);
	}
}
