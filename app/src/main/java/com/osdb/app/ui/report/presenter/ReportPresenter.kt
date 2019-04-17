package com.osdb.app.ui.report.presenter


import com.osdb.app.ui.base.presenter.BasePresenter
import com.osdb.app.ui.report.model.ReportInteractor
import com.osdb.app.ui.report.view.ReportView

interface ReportPresenter<V : ReportView, I : ReportInteractor> : BasePresenter<V, I> {
    fun getReportId(reportId: String)
}