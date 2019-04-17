package com.osdb.app.ui.dashboard.view;

import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.dashboard.beans.SportsAdapterListBean;

import java.util.ArrayList;

public interface LiveScroresView extends BaseView {
    void getSportsData(ArrayList<SportsAdapterListBean> sportsList);
    void getError(String error);
}
