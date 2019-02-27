package com.elintminds.osdb.ui.player_details_screen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;

public class InfoFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = "InfoFragment";

    private Context context;
    private TextView charitiesViewBtn, communityViewBtn, careerHighLightsViewBtn;
    private TextView charityTV, communityTV, careerTV;
    private boolean isCharityViewed = false, isCommunityViewed = false, isCareerViewed = false;

    public static InfoFragment getInstance()
    {
        return new InfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.info_fragment, container, false);
    }


    @Override
    protected void setUp(View view)
    {
        context = getContext();
        charitiesViewBtn = view.findViewById(R.id.charity_view_btn);
        communityViewBtn = view.findViewById(R.id.btn_community_work);
        careerHighLightsViewBtn = view.findViewById(R.id.btn_career);
        charityTV = view.findViewById(R.id.txt_endorsement_details);
        communityTV = view.findViewById(R.id.txt_community_work_details);
        careerTV = view.findViewById(R.id.txt_career_details);

        charitiesViewBtn.setOnClickListener(this);
        communityViewBtn.setOnClickListener(this);
        careerHighLightsViewBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.charity_view_btn :
                isCharityViewed = !isCharityViewed;
                charitiesViewBtn.setSelected(isCharityViewed);
                viewHideMethod(isCharityViewed, charitiesViewBtn, charityTV);
                break;

            case R.id.btn_community_work :
                isCommunityViewed = !isCommunityViewed;
                communityViewBtn.setSelected(isCommunityViewed);
                viewHideMethod(isCommunityViewed, communityViewBtn, communityTV);
                break;

            case R.id.btn_career :
                isCareerViewed = !isCareerViewed;
                careerHighLightsViewBtn.setSelected(isCareerViewed);
                viewHideMethod(isCareerViewed, careerHighLightsViewBtn, careerTV);
                break;
        }
    }


    private void viewHideMethod(boolean isViewed, TextView viewHideBtn, TextView valueTV)
    {
        if(isViewed)
        {
            viewHideBtn.setText(getString(R.string.hide));
            valueTV.setVisibility(View.VISIBLE);
        }
        else
        {
            viewHideBtn.setText(getString(R.string._view));
            valueTV.setVisibility(View.GONE);
        }
    }
}
