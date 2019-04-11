package com.osdb.android.ui.splash.presenter


import com.osdb.android.ui.base.presenter.BasePresenter
import com.osdb.android.ui.do_you_know.model.DiscussionCommentsInteractor
import com.osdb.android.ui.splash.view.DiscussionCommentsView

interface DiscussionCommentsPresenter<V : DiscussionCommentsView, I : DiscussionCommentsInteractor> : BasePresenter<V, I> {
     fun getDiscussion(id : String)
}