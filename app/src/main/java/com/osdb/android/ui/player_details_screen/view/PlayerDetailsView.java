package com.osdb.android.ui.player_details_screen.view;

import com.osdb.android.ui.base.view.BaseView;
import com.osdb.android.ui.player_details_screen.beans.PlayerDetailInfoBean;
import com.osdb.android.ui.player_details_screen.beans.VideosBean;
import com.osdb.android.ui.team_details_screen.beans.StatsBeanVertical;

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
            , ArrayList<StatsBeanVertical> statsBeanVerticalArrayList);

    void errorOccur(String error);
//    void fetchPlayerDetailInfo(JSONObject jsonObject);
}
