package com.elintminds.osdb.ui.report.view


import com.elintminds.osdb.ui.base.view.BaseView

interface ReportView : BaseView {

     fun getReportSuccess(reportMessage: String)
     fun error(error : String)
}