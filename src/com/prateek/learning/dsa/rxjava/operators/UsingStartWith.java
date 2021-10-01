package com.prateek.learning.dsa.rxjava.operators;

import com.prateek.learning.dsa.rxjava.Util;

public class UsingStartWith {

	public static void main(String args[]) {
		Util util = new Util();

		util.mObservableInt.startWith(0).subscribe(util.mObserverInt);
	}
}
