package com.osdb.pro.ui.do_you_know.model

import android.content.Context

import com.osdb.pro.data.app_prefs.PreferenceHelper
import com.osdb.pro.ui.base.model.BaseInteractorClass
import com.osdb.pro.ui.discussion_comments.beans.DiscussionCommentsBean
import io.reactivex.Observable


class DiscussionCommentsInterctorClass(prefHelper: PreferenceHelper, context: Context) : BaseInteractorClass(prefHelper, context),
    DiscussionCommentsInteractor {

    override fun getDiscussion(id: String): Observable<DiscussionCommentsBean> {
        return apiInterface.fetchDiscussionById(id);
    }


}