package com.osdb.pro.ui.dashboard.view;

import com.osdb.pro.ui.base.view.BaseView;
import com.osdb.pro.ui.dashboard.beans.SportsAdapterListBean;

import java.util.ArrayList;

public interface LiveScroresView extends BaseView {
    void getSportsData(ArrayList<SportsAdapterListBean> sportsList);
    void getError(String error);
}
