package com.osdb.pro.ui.report.view


import com.osdb.pro.ui.base.view.BaseView

interface ReportView : BaseView {

     fun getReportSuccess(reportMessage: String)
     fun error(error : String)
}