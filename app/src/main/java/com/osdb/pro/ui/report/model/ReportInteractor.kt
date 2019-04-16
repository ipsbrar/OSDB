package com.osdb.pro.ui.report.model


import com.osdb.pro.ui.base.model.BaseInteractor
import io.reactivex.Observable
import org.json.JSONObject
import retrofit2.Response

interface ReportInteractor : BaseInteractor {

    fun ReportThread(reportId: String): Observable<Response<JSONObject>>

}