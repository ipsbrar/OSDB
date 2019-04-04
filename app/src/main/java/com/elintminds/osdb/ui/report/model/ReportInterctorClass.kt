package com.elintminds.osdb.ui.report.model

import android.content.Context

import com.elintminds.osdb.data.app_prefs.PreferenceHelper
import com.elintminds.osdb.ui.base.model.BaseInteractorClass
import io.reactivex.Observable
import org.json.JSONObject
import retrofit2.Response

class ReportInterctorClass(prefHelper: PreferenceHelper, context: Context) : BaseInteractorClass(prefHelper, context), ReportInteractor {

    override fun ReportThread(reportId: String): Observable<Response<JSONObject>> {
        return apiInterface.ReportThread(reportId)
    }


}