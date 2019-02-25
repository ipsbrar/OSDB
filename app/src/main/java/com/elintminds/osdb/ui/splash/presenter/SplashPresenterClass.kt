package com.elintminds.osdb.ui.splash.presenter

import android.content.Context
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass
import com.elintminds.osdb.ui.settings.model.SettingsInteractor
import com.elintminds.osdb.ui.settings.model.SettingsInteractorClass
import com.elintminds.osdb.ui.settings.presenter.SettingsPresenter
import com.elintminds.osdb.ui.settings.view.SettingsView
import com.elintminds.osdb.ui.splash.model.SplashInterctorClass
import com.elintminds.osdb.ui.splash.view.SplashView


class SplashPresenterClass<V : SettingsView, I : SettingsInteractor> private constructor(
    context: Context,
    interactor: I,
    view: V
) :
    BasePresenterClass<V, I>(context, interactor, view), SettingsPresenter<V, I> {

    constructor(context: Context, view: V) : this(
        context,
        SplashInterctorClass(AppPreferenceHelperClass(context), context) as I,
        view
    ) {
    }
}
