package com.osdb.pro.ui.welcome_screen.presenter;

import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.welcome_screen.model.WelcomeInteractor;
import com.osdb.pro.ui.welcome_screen.view.WelcomeView;

public interface WelcomePresenter<V extends WelcomeView, I extends WelcomeInteractor> extends BasePresenter<V,I> {
}
