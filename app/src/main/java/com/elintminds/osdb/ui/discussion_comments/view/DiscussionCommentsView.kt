package com.elintminds.osdb.ui.splash.view


import com.elintminds.osdb.ui.base.view.BaseView
import com.elintminds.osdb.ui.discussion_comments.beans.DiscussionAdapterBean

interface DiscussionCommentsView : BaseView {

    fun getSuccess(discussData : DiscussionAdapterBean )
    fun getError(error : String)
}