package com.prateek.learning.dsa.rxjava;

import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;

public class CreatingFlowable {
	private Flowable<Integer> mFObservable = Flowable.create(new FlowableOnSubscribe<Integer>() {

		@Override
		public void subscribe(FlowableEmitter<Integer> arg0) throws Exception {
			System.out.println("subscribe, arg0=" + arg0);
			int count = 0;
			while (count++ < 10000) {
				arg0.onNext(count);
			}
		}
	}, io.reactivex.BackpressureStrategy.DROP);

	private Consumer<Integer> mSubscriber = new Consumer<Integer>() {
		@Override
		public void accept(Integer arg0) throws Exception {
			System.out.println("accept, arg0=" + arg0);
		}
	};

	public static void main(String arg[]) {
		CreatingFlowable obj = new CreatingFlowable();

		obj.mFObservable.subscribe(obj.mSubscriber, new Consumer<Throwable>() {

			@Override
			public void accept(Throwable arg0) throws Exception {
				System.out.println("accept2, arg0=" + arg0);
			}
		});
	}
}
