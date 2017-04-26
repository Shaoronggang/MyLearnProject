package com.detao.mylearnproject.rxjava;

import com.detao.mylearnproject.util.LogUtil;

import java.util.concurrent.Executors;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by shaoronggang on 2017/4/20.
 */

public abstract class UseCase {
    public final String TAG = this.getClass().getName();
    private Subscription subscription = Subscriptions.empty();
    Executors executors;
    public UseCase(Subscription subscription) {
        this.subscription = subscription;
    }

    protected abstract Observable buildUseCaseObservable();

//    public void execute(Subscriber UseCaseSubscriber){
//        this.subscription = this.buildUseCaseObservable()
//                .subscribeOn(Schedulers.from(executor))
//                .observeOn(executors)
//                .subscribe(UseCaseSubscriber);
//
//    }

    Observer<String> observer = new Observer<String>() {
        @Override
        public void onCompleted() {
            LogUtil.e(TAG,"Completed!");
        }

        @Override
        public void onError(Throwable e) {
            LogUtil.e(TAG,"Error!");
        }

        @Override
        public void onNext(String s) {
            LogUtil.e(TAG,"Item:" + s);
        }
    };

    Subscriber<String> subscriber = new Subscriber<String>() {
        @Override
        public void onCompleted() {
            LogUtil.e(TAG,"Completed!");
        }

        @Override
        public void onError(Throwable e) {
            LogUtil.e(TAG,"Error!");
        }

        @Override
        public void onNext(String s) {
            LogUtil.e(TAG,"Item:" + s);
        }
    };




}
