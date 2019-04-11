package com.osdb.android.ui.welcome_screen.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.welcome_screen.model.WelcomeInteractor;
import com.osdb.android.ui.welcome_screen.view.WelcomeView;

public interface WelcomePresenter<V extends WelcomeView, I extends WelcomeInteractor> extends BasePresenter<V,I> {
}
