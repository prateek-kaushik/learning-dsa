package com.prateek.learning.dsa.rxjava.operators;

import java.util.concurrent.TimeUnit;

import com.prateek.learning.dsa.rxjava.Util;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class UsingMerge {

	public static void main(String args[]) {
		Observable<Long> observable1 = Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, Long>() {

			@Override
			public Long apply(Long arg0) throws Exception {
				System.out.println("apply1::Long=" + arg0);
				return arg0 * arg0;
			}
		});

		Observable<Long> observable2 = Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, Long>() {

			@Override
			public Long apply(Long arg0) throws Exception {
				System.out.println("apply2::Long=" + arg0);
				return arg0 + arg0;
			}
		});

		Observable.merge(observable1, observable2).subscribe(System.out::println);

		observable1.mergeWith(observable2).subscribe(System.out::println);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
