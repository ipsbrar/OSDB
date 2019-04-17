package com.osdb.app.ui.FilterActivity.view;

import com.osdb.app.ui.base.view.BaseView;

import java.util.ArrayList;

public interface FilterActivityView extends BaseView {
    void getData(ArrayList<String> weeklyList);
    void getSeasonData(ArrayList<String> seasonList,ArrayList<String> yearList);

}
