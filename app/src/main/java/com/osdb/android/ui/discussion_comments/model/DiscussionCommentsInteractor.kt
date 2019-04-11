package com.osdb.android.ui.do_you_know.model


import com.osdb.android.ui.base.model.BaseInteractor
import com.osdb.android.ui.discussion_comments.beans.DiscussionCommentsBean
import io.reactivex.Observable

interface DiscussionCommentsInteractor: BaseInteractor {
     fun getDiscussion(id:String): Observable<DiscussionCommentsBean>

}