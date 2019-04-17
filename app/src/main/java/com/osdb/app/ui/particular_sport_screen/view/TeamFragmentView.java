package com.osdb.app.ui.particular_sport_screen.view;

import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.particular_sport_screen.beans.TeamClubBean;

import java.util.ArrayList;

public interface TeamFragmentView extends BaseView {

    void getAllListsOfTeam(ArrayList<TeamClubBean> teamClubBean);
    void getError(String error);
}
