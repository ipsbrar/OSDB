package com.osdb.android.ui.report.view


import com.osdb.android.ui.base.view.BaseView

interface ReportView : BaseView {

     fun getReportSuccess(reportMessage: String)
     fun error(error : String)
}