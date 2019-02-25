package com.elintminds.osdb.ui.report.presenter


import com.elintminds.osdb.ui.base.presenter.BasePresenter
import com.elintminds.osdb.ui.report.model.ReportInteractor


import com.elintminds.osdb.ui.splash.view.DiscussionCommentsView

interface ReportPresenter<V : DiscussionCommentsView, I : ReportInteractor> : BasePresenter<V, I> {


}