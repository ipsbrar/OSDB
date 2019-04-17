package com.osdb.app.ui.search_finding_screen.view;

import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.search_finding_screen.beans.ScheduleBean;

import java.util.ArrayList;

public interface ScheduleFragmentView extends BaseView {
    void success(ArrayList<ScheduleBean> scheduleBeanArrayList);
    void error(String error);
}
