package io.kimo.doppelganger.ui.main;

import io.kimo.doppelganger.ui.base.BaseContract;

public interface MainContract {
    interface View extends BaseContract.View<Presenter> {
        void showLoading();
        void showContent();
    }

    interface Presenter extends BaseContract.Presenter {
        void doSomething();
    }
}
