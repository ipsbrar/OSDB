package com.osdb.pro.ui.report.presenter

import android.content.Context
import android.util.Log
import com.osdb.pro.ui.base.presenter.BasePresenterClass
import com.osdb.pro.ui.report.model.ReportInteractor
import com.osdb.pro.ui.report.view.ReportView

import com.osdb.pro.utils.ConnectivityReceiver
import io.reactivex.functions.Consumer
import org.json.JSONObject
import retrofit2.Response

class ReportPresenterClass<V : ReportView, I : ReportInteractor>
private constructor(context: Context, interactor: I, view: V) : BasePresenterClass<V, I>(context, interactor, view),
    ReportPresenter<V, I> {

    override fun getReportId(reportId: String) {

        if (ConnectivityReceiver.isConnected()) {
            mvpView.showProgressDialog()
            Log.e("HomeSwipeData", "   Inside Presenter")
            compositeDisposable.add(
                interactor
                    .ReportThread(reportId)
                    .subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())
                    .subscribe(
                        Consumer<Response<JSONObject>> { jsonObj ->
                            Log.e("HomeSwipeData", "   Inside Success")
                            if (jsonObj.isSuccessful) {
                                mvpView.getReportSuccess("Report Successfully")
                            }

                            mvpView.hideProgressDialog()
                        },
                        Consumer<Throwable> { throwable ->
                            Log.e("HomeSwipeData", "   Inside Reject")
                            mvpView.error(throwable.toString())
                            mvpView.hideProgressDialog()
                        })
            )
        } else {
            mvpView.error("No Internet found")
        }
    }

}
