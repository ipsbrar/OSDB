package com.elintminds.osdb.ui.report.presenter

import android.content.Context
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass
import com.elintminds.osdb.ui.report.model.ReportInteractor

import com.elintminds.osdb.ui.splash.view.DiscussionCommentsView

class ReportPresenterClass<V : DiscussionCommentsView, I : ReportInteractor>
private constructor(context: Context, interactor: I, view: V) : BasePresenterClass<V, I>(context, interactor, view),
    ReportPresenter<V, I> {



}
