package com.osdb.app.ui.do_you_know.model


import com.osdb.app.ui.base.model.BaseInteractor
import com.osdb.app.ui.discussion_comments.beans.DiscussionCommentsBean
import io.reactivex.Observable

interface DiscussionCommentsInteractor: BaseInteractor {
     fun getDiscussion(id:String): Observable<DiscussionCommentsBean>

}