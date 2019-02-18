package com.elintminds.osdb.ui.do_you_know.model

import android.content.Context

import com.elintminds.osdb.data.app_prefs.PreferenceHelper
import com.elintminds.osdb.ui.base.model.BaseInteractorClass


class DoYouKnowInterctorClass(prefHelper: PreferenceHelper, context: Context) : BaseInteractorClass(prefHelper, context),
    DoYouKnowInteractor {


}