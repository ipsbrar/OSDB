package com.osdb.android.ui.report.presenter


import com.osdb.android.ui.base.presenter.BasePresenter
import com.osdb.android.ui.report.model.ReportInteractor
import com.osdb.android.ui.report.view.ReportView

interface ReportPresenter<V : ReportView, I : ReportInteractor> : BasePresenter<V, I> {
    fun getReportId(reportId: String)
}