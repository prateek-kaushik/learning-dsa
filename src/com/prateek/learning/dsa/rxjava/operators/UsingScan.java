package com.prateek.learning.dsa.rxjava.operators;

import com.prateek.learning.dsa.rxjava.Util;

import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

public class UsingScan {

	public static void main(String args[]) {
		Util util = new Util();

		util.mObservableInt.scan(new BiFunction<Integer, Integer, Integer>() {

			@Override
			public Integer apply(Integer arg0, Integer arg1) throws Exception {
				System.out.println("apply:: arg0=" + arg0 + ", arg1=" + arg1);
				return arg0 * arg1;
			}
		}).subscribe(new Observer<Integer>() {

			@Override
			public void onComplete() {
				System.out.println("onComplete");
			}

			@Override
			public void onError(Throwable arg0) {
				System.out.println("onError::Throwable=" + arg0);
			}

			@Override
			public void onNext(Integer arg0) {
				System.out.println("onNext::Integer=" + arg0);
			}

			@Override
			public void onSubscribe(Disposable arg0) {
				System.out.println("onSubscribe::Disposable=" + arg0);
			}
		});
	}
}
