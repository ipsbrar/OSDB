package com.osdb.android.ui.settings.presenter;

import com.osdb.android.ui.base.presenter.BasePresenter;
import com.osdb.android.ui.settings.model.SettingsInteractor;
import com.osdb.android.ui.settings.view.SettingsView;

public interface SettingsPresenter<V extends SettingsView, I extends SettingsInteractor> extends BasePresenter<V, I>
{
}
