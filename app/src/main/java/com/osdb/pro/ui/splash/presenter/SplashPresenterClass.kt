package com.osdb.pro.ui.splash.presenter

import android.content.Context
import com.osdb.pro.data.app_prefs.AppPreferenceHelperClass
import com.osdb.pro.ui.base.presenter.BasePresenterClass
import com.osdb.pro.ui.settings.model.SettingsInteractor
import com.osdb.pro.ui.settings.presenter.SettingsPresenter
import com.osdb.pro.ui.settings.view.SettingsView
import com.osdb.pro.ui.splash.model.SplashInterctorClass


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
