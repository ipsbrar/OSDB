package com.elintminds.osdb.ui.do_you_know.model

import android.content.Context

import com.elintminds.osdb.data.app_prefs.PreferenceHelper
import com.elintminds.osdb.ui.base.model.BaseInteractorClass
import com.elintminds.osdb.ui.dashboard.beans.DiscussionAdapterBean
import com.elintminds.osdb.ui.discussion_comments.beans.DiscussionCommentsBean
import io.reactivex.Observable


class DiscussionCommentsInterctorClass(prefHelper: PreferenceHelper, context: Context) : BaseInteractorClass(prefHelper, context),
    DiscussionCommentsInteractor {

    override fun getDiscussion(id: String): Observable<DiscussionCommentsBean> {
        return apiInterface.fetchDiscussionById(id);
    }


}