package com.osdb.android.ui.splash.presenter

import android.content.Context
import com.osdb.android.ui.base.presenter.BasePresenterClass
import com.osdb.android.ui.do_you_know.model.DiscussionCommentsInteractor

import com.osdb.android.ui.splash.view.DiscussionCommentsView

class DoYouKnowPresenterClass<V : DiscussionCommentsView, I : DiscussionCommentsInteractor>
private constructor(context: Context, interactor: I, view: V) : BasePresenterClass<V, I>(context, interactor, view),
    DiscussionCommentsPresenter<V, I> {
    override fun getDiscussion(id: String) {

    }


}
