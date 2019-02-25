package com.elintminds.osdb.ui.add_edit_discussion.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.add_edit_discussion.model.AddEditDiscussionnteractor;
import com.elintminds.osdb.ui.add_edit_discussion.model.AddEditDiscussionnteractorClass;
import com.elintminds.osdb.ui.add_edit_discussion.view.AddEditDiscussionView;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;

public class AddEditDiscussionPresenterClass<V extends AddEditDiscussionView, I extends AddEditDiscussionnteractor> extends BasePresenterClass<V,I> implements AddEditDiscussionPresenter<V,I>
{
    private AddEditDiscussionPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public AddEditDiscussionPresenterClass(Context context, V view) {
        this(context, (I) new AddEditDiscussionnteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}
