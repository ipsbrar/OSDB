package com.elintminds.osdb.ui.team_details_screen.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsBeans;

import java.util.ArrayList;

public interface StatsView extends BaseView {
    void success(ArrayList<StatsBeans> statsData);

    void error(String error);
}
