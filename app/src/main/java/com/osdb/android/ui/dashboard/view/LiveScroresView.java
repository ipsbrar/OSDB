package com.osdb.android.ui.dashboard.view;

import com.osdb.android.ui.base.view.BaseView;
import com.osdb.android.ui.dashboard.beans.SportsAdapterListBean;

import java.util.ArrayList;

public interface LiveScroresView extends BaseView {
    void getSportsData(ArrayList<SportsAdapterListBean> sportsList);
    void getError(String error);
}
