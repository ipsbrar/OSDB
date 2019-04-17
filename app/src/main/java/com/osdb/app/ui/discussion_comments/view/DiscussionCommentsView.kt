package com.osdb.app.ui.splash.view


import com.osdb.app.ui.base.view.BaseView
import com.osdb.app.ui.discussion_comments.beans.DiscussionCommentsBean

interface DiscussionCommentsView : BaseView {

    fun getSuccess(discussData : DiscussionCommentsBean)
    fun getError(error : String)
}