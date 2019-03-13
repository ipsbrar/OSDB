package com.elintminds.osdb.ui.player_details_screen.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.player_details_screen.beans.PlayerDetailInfoBean;
import org.json.JSONObject;

public interface PlayerDetailsView extends BaseView
{
    interface VideoPhotoAdapterListener
    {
        void onItemClick(int position);
    }

    void formattedDate(String stringDate);
    void playersAge(String stringDate);

    void fetchPlayerDetailInfo(PlayerDetailInfoBean jsonObject);
    void errorOccur(String error);
//    void fetchPlayerDetailInfo(JSONObject jsonObject);
}
