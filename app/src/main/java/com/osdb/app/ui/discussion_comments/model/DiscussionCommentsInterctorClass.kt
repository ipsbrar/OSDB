package com.osdb.app.ui.do_you_know.model

import android.content.Context

import com.osdb.app.data.app_prefs.PreferenceHelper
import com.osdb.app.ui.base.model.BaseInteractorClass
import com.osdb.app.ui.discussion_comments.beans.DiscussionCommentsBean
import io.reactivex.Observable


class DiscussionCommentsInterctorClass(prefHelper: PreferenceHelper, context: Context) : BaseInteractorClass(prefHelper, context),
    DiscussionCommentsInteractor {

    override fun getDiscussion(id: String): Observable<DiscussionCommentsBean> {
        return apiInterface.fetchDiscussionById(id);
    }


}