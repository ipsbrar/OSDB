package com.elintminds.osdb.ui.dashboard.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;

import java.util.ArrayList;

public interface LiveScroresView extends BaseView {
    void getSportsData(ArrayList<SportsAdapterListBean> sportsList);
    void getError(String error);
}
