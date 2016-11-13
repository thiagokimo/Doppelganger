package io.kimo.doppelganger.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public interface BaseContract {
    interface View <P extends Presenter> {
        P createPresenter(@Nullable Bundle savedInstanceState);
        P getPresenter();
    }

    interface Presenter {
        void createView();
        void destroyView();
    }
}
