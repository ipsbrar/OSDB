package com.elintminds.osdb.ui.splash.presenter

import android.content.Context
import android.util.Log
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass
import com.elintminds.osdb.ui.discussion_comments.beans.DiscussionAdapterBean
import com.elintminds.osdb.ui.do_you_know.model.DiscussionCommentsInteractor
import com.elintminds.osdb.ui.do_you_know.model.DiscussionCommentsInterctorClass
import com.elintminds.osdb.ui.login.model.LoginInteractorClass

import com.elintminds.osdb.ui.splash.view.DiscussionCommentsView
import io.reactivex.functions.Consumer

public class DiscussionCommentsPresenterClass<V : DiscussionCommentsView, I : DiscussionCommentsInteractor>


public constructor(context: Context,  view: V) : BasePresenterClass<V, I>(context,
    DiscussionCommentsInterctorClass(AppPreferenceHelperClass(context), context) as I, view),
    DiscussionCommentsPresenter<V, I> {

    override fun getDiscussion() {
        compositeDisposable.add(
            interactor
                .getDiscussion()
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
    }
}
