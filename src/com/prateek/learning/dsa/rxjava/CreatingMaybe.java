package com.prateek.learning.dsa.rxjava;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.disposables.Disposable;

public class CreatingMaybe {

	private Maybe<String> mObservable = Maybe.create(new MaybeOnSubscribe<String>() {

		@Override
		public void subscribe(MaybeEmitter<String> arg0) throws Exception {
			arg0.onSuccess("Prateek");

//			arg0.onComplete();

//			arg0.onError(new Exception("What!"));
		}
	});

	private MaybeObserver<String> mObserver = new MaybeObserver<String>() {

		@Override
		public void onComplete() {
			System.out.println("onComplete");
		}

		@Override
		public void onError(Throwable arg0) {
			System.out.println("onError, arg0=" + arg0);
		}

		@Override
		public void onSubscribe(Disposable arg0) {
			System.out.println("onSubscribe, arg0=" + arg0);
		}

		@Override
		public void onSuccess(String arg0) {
			System.out.println("onSuccess, arg0=" + arg0);
		}
	};

	public static void main(String args[]) {
		CreatingMaybe obj = new CreatingMaybe();

		obj.mObservable.subscribe(obj.mObserver);
	}
}
