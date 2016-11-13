package io.kimo.doppelganger.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BaseContract.Presenter> extends AppCompatActivity
        implements BaseContract.View<P> {

    private P mPresenter;

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);
        mPresenter.createView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.destroyView();
    }
}
