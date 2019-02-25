package com.elintminds.osdb.ui.settings.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.settings.model.SettingsInteractor;
import com.elintminds.osdb.ui.settings.model.SettingsInteractorClass;
import com.elintminds.osdb.ui.settings.view.SettingsView;

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
