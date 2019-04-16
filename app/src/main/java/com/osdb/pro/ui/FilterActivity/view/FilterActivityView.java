package com.osdb.pro.ui.FilterActivity.view;

import com.osdb.pro.ui.base.view.BaseView;

import java.util.ArrayList;

public interface FilterActivityView extends BaseView {
    void getData(ArrayList<String> weeklyList);
    void getSeasonData(ArrayList<String> seasonList,ArrayList<String> yearList);

}
