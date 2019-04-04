package com.elintminds.osdb.ui.player_details_screen.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.NestedScrollView;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
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
            user_endorsement_deals, user_sport_agent, user_television_agent;
    private RelativeLayout rl_endorsement_deals, rl_business_venture, rl_current_contract, rl_fan_email_address, rl_sport_agent, rl_television_agent;
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

//        relative layouts
        rl_endorsement_deals = view.findViewById(R.id.rl_endorsement_deals);
        rl_business_venture = view.findViewById(R.id.rl_business_venture);
        rl_current_contract = view.findViewById(R.id.rl_current_contract);
        rl_television_agent = view.findViewById(R.id.rl_television_agent);
        rl_sport_agent = view.findViewById(R.id.rl_sport_agent);
        rl_fan_email_address = view.findViewById(R.id.rl_fan_email_address);

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
        if (playerInfo.getPlayerHeight() != null) {
            double playerHeight = Double.parseDouble(playerInfo.getPlayerHeight());
            int intHeight = (int) playerHeight;
            int feet = intHeight / 12;
            int leftover = intHeight % 12;
            String finalHeight = feet + "'" + leftover + "\"";
            Log.e("Inches_to_feet  ", finalHeight);
            user_height.setText(finalHeight);
        }
        user_weight.setText(playerInfo.getPlayerWeight() + "lbs");
        user_college.setText(playerInfo.getPlayerCollege());
        user_place_of_birth.setText(playerInfo.getPlaceOfBirth());
        user_position.setText(playerInfo.getPlayerPosition());
        if (playerInfo.getPlayerFanMailAddress() != null
                && !playerInfo.getPlayerFanMailAddress().equalsIgnoreCase("")
                && !playerInfo.getPlayerFanMailAddress().equalsIgnoreCase("null")) {
            user_fan_email_address.setText(Html.fromHtml(playerInfo.getPlayerFanMailAddress()));
        } else {
            rl_fan_email_address.setVisibility(View.GONE);
        }
        if (playerInfo.getPlayerSportsAgent() != null
                && !playerInfo.getPlayerSportsAgent().equalsIgnoreCase("")
                && !playerInfo.getPlayerSportsAgent().equalsIgnoreCase("null")) {
            user_sport_agent.setText(playerInfo.getPlayerSportsAgent());
        } else {
            rl_sport_agent.setVisibility(View.GONE);
        }
        if (playerInfo.getPlayerTelevision() != null
                && !playerInfo.getPlayerTelevision().equalsIgnoreCase("")
                && !playerInfo.getPlayerTelevision().equalsIgnoreCase("null")) {
            user_television_agent.setText(playerInfo.getPlayerTelevision());
        } else {
            rl_television_agent.setVisibility(View.GONE);
        }

        if (playerInfo.getCurrentContract() != null && !TextUtils.isEmpty(playerInfo.getCurrentContract()) && !playerInfo.getCurrentContract().equalsIgnoreCase("null"))
            user_current_contract.setText(playerInfo.getCurrentContract());
        else
            rl_current_contract.setVisibility(View.GONE);

        if (playerInfo.getBusinessVentures() != null && !TextUtils.isEmpty(playerInfo.getBusinessVentures()) && !playerInfo.getBusinessVentures().equalsIgnoreCase("null"))
            user_business_ventures.setText(playerInfo.getBusinessVentures());
        else
            rl_business_venture.setVisibility(View.GONE);

        if (playerInfo.getEndorsementDeals() != null && !TextUtils.isEmpty(playerInfo.getEndorsementDeals()) && !playerInfo.getEndorsementDeals().equalsIgnoreCase("null"))
            user_endorsement_deals.setText(playerInfo.getEndorsementDeals());
        else
            rl_endorsement_deals.setVisibility(View.GONE);


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
