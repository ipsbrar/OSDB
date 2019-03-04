package com.elintminds.osdb.ui.do_you_know.model

import android.content.Context

import com.elintminds.osdb.data.app_prefs.PreferenceHelper
import com.elintminds.osdb.ui.base.model.BaseInteractorClass
import com.elintminds.osdb.ui.discussion_comments.beans.DiscussionAdapterBean
import io.reactivex.Observable


class DoYouKnowInterctorClass(prefHelper: PreferenceHelper, context: Context) : BaseInteractorClass(prefHelper, context),
    DiscussionCommentsInteractor {
    override fun getDiscussion(): Observable<DiscussionAdapterBean> {
        return apiInterface.fetchDiscussions()
    }


}