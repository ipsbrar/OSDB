package com.elintminds.osdb.ui.player_details_screen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.player_details_screen.beans.PlayerDetailInfoBean;

public class InfoFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = "InfoFragment";

    private Context context;
    private TextView charitiesViewBtn, communityViewBtn, careerHighLightsViewBtn;
    private TextView charityTV, communityTV, careerTV;
    private boolean isCharityViewed = false, isCommunityViewed = false, isCareerViewed = false;
    private TextView user_height, user_weight, user_college, user_place_of_birth, user_position,
            user_fan_email_address, user_current_contract, user_business_ventures,
            user_endorsement_deals,user_sport_agent,user_television_agent;

    private NestedScrollView nscroll;
    //    No data found layout
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;


    public static InfoFragment getInstance(PlayerDetailInfoBean playerDetailInfoBean) {
        InfoFragment infoFragment = new InfoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("info", playerDetailInfoBean);
        infoFragment.setArguments(bundle);


        return infoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.info_fragment, container, false);
    }


    @Override
    protected void setUp(View view) {
        context = getContext();

        //        No data found Views
        txt_no_data_title = view.findViewById(R.id.txt_no_data_title);
        txt_no_data_disp = view.findViewById(R.id.txt_no_data_disp);
        no_data = view.findViewById(R.id.no_data);
        txt_no_data_title.setText(getString(R.string.no_data_found));
        txt_no_data_disp.setText(getString(R.string.please_try_again));
        no_data.setVisibility(View.GONE);

        nscroll = view.findViewById(R.id.nscroll);
        charitiesViewBtn = view.findViewById(R.id.charity_view_btn);
        communityViewBtn = view.findViewById(R.id.btn_community_work);
        careerHighLightsViewBtn = view.findViewById(R.id.btn_career);
        charityTV = view.findViewById(R.id.txt_endorsement_details);
        communityTV = view.findViewById(R.id.txt_community_work_details);
        careerTV = view.findViewById(R.id.txt_career_details);
        user_height = view.findViewById(R.id.user_height);
        user_weight = view.findViewById(R.id.user_weight);
        user_college = view.findViewById(R.id.user_college);
        user_place_of_birth = view.findViewById(R.id.user_place_of_birth);
        user_position = view.findViewById(R.id.user_position);
        user_fan_email_address = view.findViewById(R.id.user_fan_email_address);
        user_current_contract = view.findViewById(R.id.user_current_contract);
        user_business_ventures = view.findViewById(R.id.user_business_ventures);
        user_endorsement_deals = view.findViewById(R.id.user_endorsement_deals);
        user_sport_agent = view.findViewById(R.id.user_sport_agent);
        user_television_agent = view.findViewById(R.id.user_television_agent);

        Bundle bundle = getArguments();
        if (bundle != null) {
            PlayerDetailInfoBean playerInfo = (PlayerDetailInfoBean) bundle.getSerializable("info");
            if (playerInfo != null) {
                no_data.setVisibility(View.GONE);
                nscroll.setVisibility(View.VISIBLE);
                SetViewData(playerInfo);
            } else {
                no_data.setVisibility(View.VISIBLE);
                nscroll.setVisibility(View.GONE);
            }
        }

        charitiesViewBtn.setOnClickListener(this);
        communityViewBtn.setOnClickListener(this);
        careerHighLightsViewBtn.setOnClickListener(this);
    }

    private void SetViewData(PlayerDetailInfoBean playerInfo) {

        user_height.setText(playerInfo.getPlayerHeight());
        user_weight.setText(playerInfo.getPlayerWeight());
        user_college.setText(playerInfo.getPlayerCollege());
        user_place_of_birth.setText(playerInfo.getPlaceOfBirth());
        user_position.setText(playerInfo.getPlayerPosition());
        user_fan_email_address.setText(playerInfo.getPlayerFanMailAddress());
        user_current_contract.setText(playerInfo.getCurrentContract());
        user_business_ventures.setText(playerInfo.getBusinessVentures());
        user_endorsement_deals.setText(playerInfo.getEndorsementDeals());
        user_sport_agent.setText(playerInfo.getPlayerSportsAgent());
        user_television_agent.setText(playerInfo.getPlayerTelevision());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.charity_view_btn:
                isCharityViewed = !isCharityViewed;
                charitiesViewBtn.setSelected(isCharityViewed);
                viewHideMethod(isCharityViewed, charitiesViewBtn, charityTV);
                break;

            case R.id.btn_community_work:
                isCommunityViewed = !isCommunityViewed;
                communityViewBtn.setSelected(isCommunityViewed);
                viewHideMethod(isCommunityViewed, communityViewBtn, communityTV);
                break;

            case R.id.btn_career:
                isCareerViewed = !isCareerViewed;
                careerHighLightsViewBtn.setSelected(isCareerViewed);
                viewHideMethod(isCareerViewed, careerHighLightsViewBtn, careerTV);
                break;
        }
    }


    private void viewHideMethod(boolean isViewed, TextView viewHideBtn, TextView valueTV) {
        if (isViewed) {
            viewHideBtn.setText(getString(R.string.hide));
            valueTV.setVisibility(View.VISIBLE);
        } else {
            viewHideBtn.setText(getString(R.string._view));
            valueTV.setVisibility(View.GONE);
        }
    }
}
