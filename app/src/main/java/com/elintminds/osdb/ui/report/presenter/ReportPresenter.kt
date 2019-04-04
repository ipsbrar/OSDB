package com.elintminds.osdb.ui.report.presenter


import com.elintminds.osdb.ui.base.presenter.BasePresenter
import com.elintminds.osdb.ui.report.model.ReportInteractor
import com.elintminds.osdb.ui.report.view.ReportView


import com.elintminds.osdb.ui.splash.view.DiscussionCommentsView

interface ReportPresenter<V : ReportView, I : ReportInteractor> : BasePresenter<V, I> {
    fun getReportId(reportId: String)
}