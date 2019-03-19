package com.elintminds.osdb.ui.search_finding_screen.view;

import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.search_finding_screen.beans.ScheduleBean;

import java.util.ArrayList;

public interface ScheduleFragmentView extends BaseView {
    void success(ArrayList<ScheduleBean> scheduleBeanArrayList);
    void error(String error);
}
