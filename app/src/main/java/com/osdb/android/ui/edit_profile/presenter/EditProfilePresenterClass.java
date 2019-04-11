package com.osdb.android.ui.edit_profile.presenter;

import android.content.Context;
import com.osdb.android.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.android.ui.base.presenter.BasePresenterClass;
import com.osdb.android.ui.base.view.BaseView;
import com.osdb.android.ui.edit_profile.model.EditProfileInteractor;
import com.osdb.android.ui.edit_profile.model.EditProfileInteractorClass;

public class EditProfilePresenterClass<V extends BaseView, I extends EditProfileInteractor>
        extends BasePresenterClass<V, I> implements EditProfilePresenter<V, I>
{
    private EditProfilePresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public EditProfilePresenterClass(Context context, V view) {
        this(context, (I) new EditProfileInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}
