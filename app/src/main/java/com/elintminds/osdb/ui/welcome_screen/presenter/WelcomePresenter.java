package com.elintminds.osdb.ui.welcome_screen.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.welcome_screen.model.WelcomeInteractor;
import com.elintminds.osdb.ui.welcome_screen.view.WelcomeView;

public interface WelcomePresenter<V extends WelcomeView, I extends WelcomeInteractor> extends BasePresenter<V,I> {
}
