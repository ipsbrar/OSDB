package com.osdb.android.ui.splash.presenter

import android.content.Context
import com.osdb.android.data.app_prefs.AppPreferenceHelperClass
import com.osdb.android.ui.base.presenter.BasePresenterClass
import com.osdb.android.ui.settings.model.SettingsInteractor
import com.osdb.android.ui.settings.presenter.SettingsPresenter
import com.osdb.android.ui.settings.view.SettingsView
import com.osdb.android.ui.splash.model.SplashInterctorClass


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
