package com.prateek.learning.dsa.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Util {
	public Observable<Integer> mObservableInt = Observable.create(new ObservableOnSubscribe<Integer>() {

		@Override
		public void subscribe(ObservableEmitter<Integer> arg0) throws Exception {
			int i = 0;
			while (i++ < 10) {
				arg0.onNext(i);
			}
			arg0.onComplete();
		}
	});

	public Observable<String> mObservableString = Observable.create(new ObservableOnSubscribe<String>() {

		@Override
		public void subscribe(ObservableEmitter<String> arg0) throws Exception {
			int i = 0;
			while (i++ < 10) {
				arg0.onNext("element " + i);
			}
			arg0.onComplete();
		}
	});

	public Observer<Integer> mObserverInt = new Observer<Integer>() {

		@Override
		public void onSubscribe(Disposable arg0) {
			System.out.println("onSubscribe::Disposable=" + arg0.hashCode());
		}

		@Override
		public void onNext(Integer arg0) {
			System.out.println("onNext::Integer=" + arg0);
		}

		@Override
		public void onError(Throwable arg0) {
			System.out.println("onError::Throwable=" + arg0);
		}

		@Override
		public void onComplete() {
			System.out.println("onComplete");
		}
	};

	public Observer<String> mObserverString = new Observer<String>() {

		@Override
		public void onSubscribe(Disposable arg0) {
			System.out.println("onSubscribe::Disposable=" + arg0.hashCode());
		}

		@Override
		public void onNext(String arg0) {
			System.out.println("onNext::String=" + arg0);
		}

		@Override
		public void onError(Throwable arg0) {
			System.out.println("onError::Throwable=" + arg0);
		}

		@Override
		public void onComplete() {
			System.out.println("onComplete");
		}
	};

}
