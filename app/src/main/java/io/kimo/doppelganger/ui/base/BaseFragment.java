package io.kimo.doppelganger.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseFragment<P extends BaseContract.Presenter> extends Fragment
        implements BaseContract.View<P> {

    private P mPresenter;

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = createPresenter(savedInstanceState);
        ButterKnife.bind(getActivity(), view);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.createView();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.destroyView();
    }
}
