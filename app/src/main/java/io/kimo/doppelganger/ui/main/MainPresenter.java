package io.kimo.doppelganger.ui.main;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private CompositeSubscription mSubscriptions = new CompositeSubscription();

    public MainPresenter(@NonNull MainContract.View view) {
        mView = view;
    }

    @Override
    public void createView() {
        doSomething();
    }

    @Override
    public void destroyView() {
        mSubscriptions.unsubscribe();
    }

    @Override
    public void doSomething() {
        mSubscriptions.add(Observable.timer(5, TimeUnit.SECONDS)
                .doOnSubscribe(mView::showLoading)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(passed5Seconds -> {
                    mView.showContent();
                })
        );
    }
}
