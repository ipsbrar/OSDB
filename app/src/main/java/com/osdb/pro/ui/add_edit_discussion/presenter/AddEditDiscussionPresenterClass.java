package com.osdb.pro.ui.add_edit_discussion.presenter;

import android.content.Context;
import com.osdb.pro.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.pro.ui.add_edit_discussion.model.AddEditDiscussionnteractor;
import com.osdb.pro.ui.add_edit_discussion.model.AddEditDiscussionnteractorClass;
import com.osdb.pro.ui.add_edit_discussion.view.AddEditDiscussionView;
import com.osdb.pro.ui.base.presenter.BasePresenterClass;

public class AddEditDiscussionPresenterClass<V extends AddEditDiscussionView, I extends AddEditDiscussionnteractor> extends BasePresenterClass<V,I> implements AddEditDiscussionPresenter<V,I>
{
    private AddEditDiscussionPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public AddEditDiscussionPresenterClass(Context context, V view) {
        this(context, (I) new AddEditDiscussionnteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}
