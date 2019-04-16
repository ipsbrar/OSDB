package com.osdb.pro.ui.do_you_know.model


import com.osdb.pro.ui.base.model.BaseInteractor
import com.osdb.pro.ui.discussion_comments.beans.DiscussionCommentsBean
import io.reactivex.Observable

interface DiscussionCommentsInteractor: BaseInteractor {
     fun getDiscussion(id:String): Observable<DiscussionCommentsBean>

}