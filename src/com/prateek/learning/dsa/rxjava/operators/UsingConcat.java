package com.prateek.learning.dsa.rxjava.operators;

import com.prateek.learning.dsa.rxjava.Util;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class UsingConcat {

	public static void main(String args[]) {
		Util util = new Util();

		Observable.concat(util.mObservableInt, util.mObservableInt).subscribe(new Observer<Integer>() {

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

		Observable.concat(util.mObservableInt, util.mObservableInt).subscribe(new Consumer<Integer>() {

			@Override
			public void accept(Integer arg0) throws Exception {
				System.out.println("accept::Integer=" + arg0);
			}
		});

		util.mObservableInt.concatWith(util.mObservableInt).subscribe(System.out::println);
	}
}
