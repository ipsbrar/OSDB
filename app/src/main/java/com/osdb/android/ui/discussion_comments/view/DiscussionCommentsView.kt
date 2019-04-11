package com.osdb.android.ui.splash.view


import com.osdb.android.ui.base.view.BaseView
import com.osdb.android.ui.discussion_comments.beans.DiscussionCommentsBean

interface DiscussionCommentsView : BaseView {

    fun getSuccess(discussData : DiscussionCommentsBean)
    fun getError(error : String)
}