package com.prateek.learning.dsa.rxjava.operators;

import com.prateek.learning.dsa.rxjava.Util;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class UsingZip {

	public static void main(String args[]) {
		Util util = new Util();

		Observable.zip(util.mObservableInt, util.mObservableString, new BiFunction<Integer, String, String>() {

			@Override
			public String apply(Integer arg0, String arg1) throws Exception {
				System.out.println("zip::arg0=" + arg0 + ", arg1=" + arg1);
				return arg0 + "-zip-" + arg1;
			}
		}).subscribe(System.out::println);

		util.mObservableInt.zipWith(util.mObservableString, new BiFunction<Integer, String, String>() {

			@Override
			public String apply(Integer arg0, String arg1) throws Exception {
				System.out.println("zip::arg0=" + arg0 + ", arg1=" + arg1);
				return arg0 + "-zipper-" + arg1;
			}
		}).subscribe(System.out::println);
	}
}
