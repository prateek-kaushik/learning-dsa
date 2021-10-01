package com.prateek.learning.dsa.rxjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CreatingObservables {
	Disposable disposable;
	Observable mObservable;
	Observer<Integer> mObserver = new Observer<Integer>() {

		@Override
		public void onComplete() {
			System.out.println("onComplete1");
			printCurrentThread();
			disposable.dispose();
		}

		@Override
		public void onError(Throwable arg0) {
			System.out.println("onError=" + arg0);

		}

		@Override
		public void onNext(Integer arg0) {
			System.out.println("onNext=" + arg0);
			printCurrentThread();
		}

		@Override
		public void onSubscribe(Disposable arg0) {
			disposable = arg0;
			System.out.println("onSubscribe1=" + arg0.hashCode());
			printCurrentThread();
		}
	};

	public Observable<List<Integer>> getObservableUsingJust() {
		if (mObservable == null) {
			mObservable = Observable.just(getRandomIntList());
		}
		return mObservable;
	}

	public Observable<Integer> getObservableUsingCreate() {
//		if (mObservable == null) {
//			mObservable = 
		return Observable.create(new ObservableOnSubscribe<Integer>() {
			Random random = new Random();

			@Override
			public void subscribe(ObservableEmitter<Integer> arg0) throws Exception {
				int emitterHash = arg0.hashCode();
				System.out.println("*******subscribe=" + emitterHash);
				for (int i = 0; i < 10; i++) {
					int next = random.nextInt();
					System.out.println(emitterHash + "--emitting=" + next);
					arg0.onNext(next);
				}
//				arg0.onComplete();
				arg0.onError(new Exception("What!!"));
			}
		});
//		}
//		return mObservable;
	}

	public List<Integer> getRandomIntList() {
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(random.nextInt());
		}
		return list;
	}

	public static void main(String args[]) {
		CreatingObservables obj = new CreatingObservables();

		ExecutorService service = Executors.newFixedThreadPool(10);
		Scheduler scheduler = Schedulers.from(service);

//		System.out.println("calling cache");
//		Observable<Integer> cached = obj.getObservableUsingCreate().cache();
//		System.out.println("cache called");

		obj.getObservableUsingCreate().subscribeOn(scheduler).observeOn(scheduler).subscribe(obj.mObserver);

		obj.getObservableUsingCreate().subscribeOn(scheduler).observeOn(scheduler).subscribe(obj.mObserver);

		obj.getObservableUsingCreate().subscribeOn(scheduler).observeOn(scheduler).subscribe(new Consumer<Integer>() {

			@Override
			public void accept(Integer arg0) throws Exception {
				System.out.println("accept1=" + arg0);
			}
		}, new Consumer<Throwable>() {

			@Override
			public void accept(Throwable arg0) throws Exception {
				System.out.println("accept2=" + arg0);
			}
		});

//		obj.getObservableUsingJust().subscribeOn(Schedulers.computation()).subscribe(new Observer<List<Integer>>() {
//
//			@Override
//			public void onComplete() {
//				System.out.println("onComplete2");
//
//			}
//
//			@Override
//			public void onError(Throwable arg0) {
//				System.out.println("onError=" + arg0);
//
//			}
//
//			@Override
//			public void onNext(List<Integer> arg0) {
//				System.out.println("onNext=" + arg0);
//
//			}
//
//			@Override
//			public void onSubscribe(Disposable arg0) {
//				System.out.println("onSubscribe2=" + arg0);
//
//			}
//		});
	}

	public void printCurrentThread() {
		System.out.println("current thread=" + Thread.currentThread().getName());
	}
}
