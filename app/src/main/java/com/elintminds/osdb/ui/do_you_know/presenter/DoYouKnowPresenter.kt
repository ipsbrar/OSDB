package com.elintminds.osdb.ui.splash.presenter


import com.elintminds.osdb.ui.base.presenter.BasePresenter
import com.elintminds.osdb.ui.do_you_know.model.DiscussionCommentsInteractor
import com.elintminds.osdb.ui.splash.view.DiscussionCommentsView

interface DoYouKnowPresenter<V : DiscussionCommentsView, I : DiscussionCommentsInteractor> : BasePresenter<V, I> {


}