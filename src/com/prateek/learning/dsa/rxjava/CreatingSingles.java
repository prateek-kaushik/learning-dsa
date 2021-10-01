package com.prateek.learning.dsa.rxjava;

import java.util.Random;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.observers.DisposableSingleObserver;

public class CreatingSingles {

	private Single<Integer> singleobservable = Single.create(new SingleOnSubscribe<Integer>() {

		@Override
		public void subscribe(SingleEmitter<Integer> arg0) throws Exception {
			arg0.onSuccess(123);
//			arg0.onError(new Exception("Single error"));
		}
	});

	private DisposableSingleObserver<Integer> singleObserver = new DisposableSingleObserver<Integer>() {

		@Override
		public void onError(Throwable arg0) {
			System.out.println(arg0);
		}

		@Override
		public void onSuccess(Integer arg0) {
			System.out.println(arg0);
		}
	};

	public static void main(String args[]) {
		CreatingSingles obj = new CreatingSingles();

		obj.singleobservable.subscribe(obj.singleObserver);
	}

}
