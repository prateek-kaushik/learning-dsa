package com.prateek.learning.dsa.rxjava.operators;

import java.util.List;

import com.prateek.learning.dsa.rxjava.Util;

import io.reactivex.functions.Consumer;

public class UsingToListAndToSortedList {

	public static void main(String args[]) {
		Util util = new Util();

		util.mObservableInt
		.repeat(2)
		.toList()
		.subscribe(new Consumer<List<Integer>>() {

			@Override
			public void accept(List<Integer> arg0) throws Exception {
				System.out.println("accept:: List=" + arg0);
			}
		});
		
		util.mObservableInt
		.repeat(2)
		.toSortedList()
		.subscribe(new Consumer<List<Integer>>() {

			@Override
			public void accept(List<Integer> arg0) throws Exception {
				System.out.println("accept:: List=" + arg0);
			}
		});
	}
}
