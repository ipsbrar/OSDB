package com.osdb.app.ui.report.model


import com.osdb.app.ui.base.model.BaseInteractor
import io.reactivex.Observable
import org.json.JSONObject
import retrofit2.Response

interface ReportInteractor : BaseInteractor {

    fun ReportThread(reportId: String): Observable<Response<JSONObject>>

}