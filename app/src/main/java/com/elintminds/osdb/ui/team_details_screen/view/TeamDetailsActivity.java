package com.elintminds.osdb.ui.team_details_screen.view;

import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.dashboard.adapters.LatestViewPagerFragment;
import com.elintminds.osdb.ui.dashboard.view.NewsFragment;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsBeans;
import com.elintminds.osdb.utils.NonSwipeableViewPager;

import java.util.ArrayList;

public class TeamDetailsActivity extends BaseActivity implements TeamDetailsView, View.OnClickListener {
    private TabLayout tabs;
    private TextView title, followBtn, stadium_txt;
    private ImageView backBtn, team_logo_img;
    private boolean isFollowing = false;
    private String divisionName, teamName, teamId, clubName;
    private ArrayList<StatsBeans> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details);
        if (getIntent() != null) {

            teamName = getIntent().getStringExtra("TEAM_NAME");
            divisionName = getIntent().getStringExtra("DIVISION_NAME");
            teamId = getIntent().getStringExtra("TEAM_ID");
            clubName = getIntent().getStringExtra("CLUB_NAME");
            String profilePic = getIntent().getStringExtra("PROFILE_PIC");
            team_logo_img = findViewById(R.id.team_logo_img);
            stadium_txt = findViewById(R.id.stadium_txt);
            stadium_txt.setText(divisionName.equalsIgnoreCase("NBA") ? "Arena" : "Stadium");
            if (profilePic != null) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.img_player_empty);
                Glide.with(this).setDefaultRequestOptions(requestOptions).load(profilePic).into(team_logo_img);
            }

        }
        initializeViews();


    }


    private void initializeViews() {
        title = findViewById(R.id.teamName);
        title.setText(teamName != null ? teamName : "");

        tabs = findViewById(R.id.team_details_tabs);

        backBtn = findViewById(R.id.back_btn);
        followBtn = findViewById(R.id.follow_btn);
        NonSwipeableViewPager viewPager = findViewById(R.id.team_details_viewpager);
        viewPager.setOffscreenPageLimit(3);
        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);

        setDividerForTabs();

        backBtn.setOnClickListener(this);
        followBtn.setOnClickListener(this);
    }

    private void setupViewPager(ViewPager upViewPager) {
        LatestViewPagerFragment adapter = new LatestViewPagerFragment(getSupportFragmentManager());
        adapter.addFragment(NewsFragment.getInstance(), getString(R.string.news));
        adapter.addFragment(StatsFragment.getInstance(arrayList, teamId), getString(R.string.stats));
        adapter.addFragment(TeamPlayersFragment.getInstance(teamName, divisionName, teamId,clubName), getString(R.string.players));
        upViewPager.setAdapter(adapter);
    }

    private void setDividerForTabs() {
        View root = tabs.getChildAt(0);
        if (root instanceof LinearLayout) {
            ((LinearLayout) root).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(getResources().getColor(R.color.color_EFEFEF));
            drawable.setSize(2, 1);
            ((LinearLayout) root).setDividerPadding(0);
            ((LinearLayout) root).setDividerDrawable(drawable);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_btn:
                onBackPressed();
                break;

            case R.id.follow_btn:
                isFollowing = !isFollowing;
                followBtn.setSelected(isFollowing);
                if (isFollowing) {
                    followBtn.setText(getString(R.string.following));
                } else {
                    followBtn.setText(getString(R.string.follow));
                }
                break;
        }
    }
}
