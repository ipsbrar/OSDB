package com.elintminds.osdb.ui.settings.presenter;

import com.elintminds.osdb.ui.base.presenter.BasePresenter;
import com.elintminds.osdb.ui.settings.model.SettingsInteractor;
import com.elintminds.osdb.ui.settings.view.SettingsView;

public interface SettingsPresenter<V extends SettingsView, I extends SettingsInteractor> extends BasePresenter<V, I>
{
}
