package com.prateek.learning.dsa.rxjava.operators;

import com.prateek.learning.dsa.rxjava.Util;

public class UsingRepeat {

	public static void main(String args[]) {
		Util util = new Util();

		util.mObservableInt.repeat(2).subscribe(util.mObserverInt);
		
//		util.mObservableInt.repeat(0).subscribe(util.mObserverInt);
		
//		util.mObservableInt.repeat(-1).subscribe(util.mObserverInt);
	}
}
