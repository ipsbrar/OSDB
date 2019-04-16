package com.osdb.pro.ui.settings.presenter;

import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.settings.model.SettingsInteractor;
import com.osdb.pro.ui.settings.view.SettingsView;

public interface SettingsPresenter<V extends SettingsView, I extends SettingsInteractor> extends BasePresenter<V, I>
{
}
