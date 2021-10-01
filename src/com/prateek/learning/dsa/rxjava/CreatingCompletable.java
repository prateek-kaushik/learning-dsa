package com.prateek.learning.dsa.rxjava;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class CreatingCompletable {
	private Completable mCompleteable = Completable.create(new CompletableOnSubscribe() {

		@Override
		public void subscribe(CompletableEmitter arg0) throws Exception {
			arg0.onComplete();

//			arg0.onError(new Exception("What!"));
		}
	});

	private CompletableObserver mObserver = new CompletableObserver() {

		@Override
		public void onSubscribe(Disposable arg0) {
			System.out.println("onSubscribe, arg0=" + arg0);
		}

		@Override
		public void onError(Throwable arg0) {
			System.out.println("onError, arg0=" + arg0);
		}

		@Override
		public void onComplete() {
			System.out.println("onComplete");
		}
	};

	public static void main(String args[]) {
		CreatingCompletable obj = new CreatingCompletable();

		obj.mCompleteable.subscribe(obj.mObserver);
	}
}
