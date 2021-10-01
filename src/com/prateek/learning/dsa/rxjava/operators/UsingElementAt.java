package com.prateek.learning.dsa.rxjava.operators;

import com.prateek.learning.dsa.rxjava.Util;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Predicate;

public class UsingElementAt {

	public static void main(String args[]) {
		Util util = new Util();

		util.mObservableInt.elementAt(9).subscribe(new MaybeObserver<Integer>() {

			@Override
			public void onComplete() {
				System.out.println("onComplete");
			}

			@Override
			public void onError(Throwable arg0) {
				System.out.println("onError::Throwable=" + arg0);
			}

			@Override
			public void onSubscribe(Disposable arg0) {
				System.out.println("onSubscribe::Disposable=" + arg0);
			}

			@Override
			public void onSuccess(Integer arg0) {
				System.out.println("onSuccess::Integer=" + arg0);
			}
		});
	}
}
