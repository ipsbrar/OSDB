package com.osdb.pro.ui.settings.presenter;

import android.content.Context;
import com.osdb.pro.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.pro.ui.base.presenter.BasePresenterClass;
import com.osdb.pro.ui.settings.model.SettingsInteractor;
import com.osdb.pro.ui.settings.model.SettingsInteractorClass;
import com.osdb.pro.ui.settings.view.SettingsView;

public class SettingsPresenterClass<V extends SettingsView, I extends SettingsInteractor>
        extends BasePresenterClass<V, I> implements SettingsPresenter<V, I>
{
    private SettingsPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public SettingsPresenterClass(Context context, V view) {
        this(context, (I) new SettingsInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}
