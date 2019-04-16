package com.osdb.pro.ui.report.presenter


import com.osdb.pro.ui.base.presenter.BasePresenter
import com.osdb.pro.ui.report.model.ReportInteractor
import com.osdb.pro.ui.report.view.ReportView

interface ReportPresenter<V : ReportView, I : ReportInteractor> : BasePresenter<V, I> {
    fun getReportId(reportId: String)
}