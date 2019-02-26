package com.elintminds.osdb.ui.calendar_screen.presenter;

import android.content.Context;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.calendar_screen.model.PollsCalendarInteractor;
import com.elintminds.osdb.ui.calendar_screen.model.PollsCalendarInteractorClass;
import com.elintminds.osdb.ui.calendar_screen.view.PollsCalendarView;

public class PollsCalendarPresenterClass<V extends PollsCalendarView, I extends PollsCalendarInteractor>
        extends BasePresenterClass<V, I> implements PollsCalendarPresenter<V, I>
{
    private PollsCalendarPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public PollsCalendarPresenterClass(Context context, V view) {
        this(context, (I) new PollsCalendarInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }
}
