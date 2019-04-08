package com.elintminds.osdb.ui.player_details_screen.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.player_details_screen.beans.PlayerDetailInfoBean;
import com.elintminds.osdb.ui.player_details_screen.beans.VideosBean;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsBeans;

import java.util.ArrayList;

public interface PlayerDetailsView extends BaseView {
    interface VideoPhotoAdapterListener {
        void onItemClick(String path);
    }

    void formattedDate(String stringDate);

    void playersAge(String stringDate);

    void fetchPlayerDetailInfo(PlayerDetailInfoBean jsonObject
            , ArrayList<String> careerHeightsArray
            , ArrayList<String> imageListArray
            , ArrayList<VideosBean> videosBeanArrayList
            , String bio
            , ArrayList<StatsBeans> statsData);

    void errorOccur(String error);
//    void fetchPlayerDetailInfo(JSONObject jsonObject);
}
