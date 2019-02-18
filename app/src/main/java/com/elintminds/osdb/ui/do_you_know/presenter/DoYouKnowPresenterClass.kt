package com.elintminds.osdb.ui.splash.presenter

import android.content.Context
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass
import com.elintminds.osdb.ui.do_you_know.model.DoYouKnowInteractor

import com.elintminds.osdb.ui.splash.view.DoYouKnowView

class DoYouKnowPresenterClass<V : DoYouKnowView, I : DoYouKnowInteractor>
private constructor(context: Context, interactor: I, view: V) : BasePresenterClass<V, I>(context, interactor, view),
    DoYouKnowPresenter<V, I> {



}
