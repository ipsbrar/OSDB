package com.elintminds.osdb.ui.do_you_know.model


import com.elintminds.osdb.ui.base.model.BaseInteractor
import com.elintminds.osdb.ui.discussion_comments.beans.DiscussionAdapterBean
import io.reactivex.Observable

interface DiscussionCommentsInteractor: BaseInteractor {
     fun getDiscussion(): Observable<DiscussionAdapterBean>

}