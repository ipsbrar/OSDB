package com.osdb.app.ui.settings.presenter;

import com.osdb.app.ui.base.presenter.BasePresenter;
import com.osdb.app.ui.settings.model.SettingsInteractor;
import com.osdb.app.ui.settings.view.SettingsView;

public interface SettingsPresenter<V extends SettingsView, I extends SettingsInteractor> extends BasePresenter<V, I>
{
}
