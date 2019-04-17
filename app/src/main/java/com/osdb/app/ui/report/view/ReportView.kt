package com.osdb.app.ui.report.view


import com.osdb.app.ui.base.view.BaseView

interface ReportView : BaseView {

     fun getReportSuccess(reportMessage: String)
     fun error(error : String)
}