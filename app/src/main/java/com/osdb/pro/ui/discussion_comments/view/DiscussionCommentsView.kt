package com.osdb.pro.ui.splash.view


import com.osdb.pro.ui.base.view.BaseView
import com.osdb.pro.ui.discussion_comments.beans.DiscussionCommentsBean

interface DiscussionCommentsView : BaseView {

    fun getSuccess(discussData : DiscussionCommentsBean)
    fun getError(error : String)
}