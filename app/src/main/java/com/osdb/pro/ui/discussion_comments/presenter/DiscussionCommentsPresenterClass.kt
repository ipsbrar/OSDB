package com.osdb.pro.ui.splash.presenter

import android.content.Context
import android.util.Log
import com.osdb.pro.data.app_prefs.AppPreferenceHelperClass
import com.osdb.pro.ui.base.presenter.BasePresenterClass
import com.osdb.pro.ui.do_you_know.model.DiscussionCommentsInteractor
import com.osdb.pro.ui.do_you_know.model.DiscussionCommentsInterctorClass

import com.osdb.pro.ui.splash.view.DiscussionCommentsView
import com.osdb.pro.utils.ConnectivityReceiver

public class DiscussionCommentsPresenterClass<V : DiscussionCommentsView, I : DiscussionCommentsInteractor>


public constructor(context: Context,  view: V) : BasePresenterClass<V, I>(context,
    DiscussionCommentsInterctorClass(AppPreferenceHelperClass(context), context) as I, view),
    DiscussionCommentsPresenter<V, I> {


    override fun getDiscussion(id :String) {
        if (ConnectivityReceiver.isConnected()){
        compositeDisposable.add(
            interactor
                .getDiscussion(id)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(
                    { discussionData ->
                        Log.e("NewsData", "Success=======" )
                        mvpView.getSuccess(discussionData)
                    },
                    { throwable ->
                        Log.e("NewsData", "Error=======    $throwable")
                        mvpView.getError(throwable.toString())
                    })
        )
    }else{
            mvpView.getError("No Internet Connection")
        }}
}
