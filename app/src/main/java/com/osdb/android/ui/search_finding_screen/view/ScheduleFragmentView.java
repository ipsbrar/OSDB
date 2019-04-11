package com.osdb.android.ui.search_finding_screen.view;

import com.osdb.android.ui.base.view.BaseView;
import com.osdb.android.ui.search_finding_screen.beans.ScheduleBean;

import java.util.ArrayList;

public interface ScheduleFragmentView extends BaseView {
    void success(ArrayList<ScheduleBean> scheduleBeanArrayList);
    void error(String error);
}
