package io.kimo.doppelganger.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import io.kimo.doppelganger.R;
import io.kimo.doppelganger.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View {

    @BindView(R.id.view_content)
    View mContentView;

    @BindView(R.id.view_loading)
    View mLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick(R.id.button_show_loading)
    public void onShowLoadingClicked() {
        getPresenter().doSomething();
    }

    @Override
    public void showLoading() {
        mLoadingView.setVisibility(View.VISIBLE);
        mContentView.setVisibility(View.GONE);
    }

    @Override
    public void showContent() {
        mContentView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    public MainContract.Presenter createPresenter(@Nullable Bundle savedInstanceState) {
        return new MainPresenter(this);
    }
}
