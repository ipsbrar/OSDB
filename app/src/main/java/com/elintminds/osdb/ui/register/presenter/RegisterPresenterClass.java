package com.elintminds.osdb.ui.register.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.register.model.RegisterInteractor;
import com.elintminds.osdb.ui.register.model.RegisterInteractorClass;
import com.elintminds.osdb.ui.register.view.RegisterView;

public class RegisterPresenterClass<V extends RegisterView, I extends RegisterInteractor> extends BasePresenterClass<V,I> implements RegisterPresenter<V,I>
{
    private RegisterPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public RegisterPresenterClass(Context context, V view) {
        this(context, (I) new RegisterInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}
