package com.elintminds.osdb.ui.splash.view


import com.elintminds.osdb.ui.base.view.BaseView
import com.elintminds.osdb.ui.dashboard.beans.DiscussionAdapterBean
import com.elintminds.osdb.ui.discussion_comments.beans.DiscussionCommentsBean

interface DiscussionCommentsView : BaseView {

    fun getSuccess(discussData : DiscussionCommentsBean)
    fun getError(error : String)
}