package com.elintminds.osdb.ui.player_details_screen.view;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.dashboard.adapters.LatestViewPagerFragment;
import com.elintminds.osdb.ui.dashboard.view.NewsFragment;
import com.elintminds.osdb.ui.player_details_screen.beans.PlayerDetailInfoBean;
import com.elintminds.osdb.ui.player_details_screen.presenter.PlayerDetailsPresenterClass;
import com.elintminds.osdb.ui.team_details_screen.view.StatsFragment;


public class PlayerDetailsActivity extends BaseActivity implements PlayerDetailsView, View.OnClickListener {
    private TabLayout tabs;
    private TextView title, followBtn, user_age, user_date_of_birth, user_team, user_zone;
    private ImageView backBtn;
    private boolean isFollowing = false;
    private String age, teamName, divisionName, playerId, playerName;
    private PlayerDetailsPresenterClass playerDetailsPresenterClass;
    private PlayerDetailInfoBean playerDetailInfoBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail_screen);

        initializeViews();

    }

    private void initializeViews() {
        title = findViewById(R.id.player_details_title);
        tabs = findViewById(R.id.player_details_tabs);
        backBtn = findViewById(R.id.back_btn);
        followBtn = findViewById(R.id.follow_btn);
        user_age = findViewById(R.id.user_age);
        user_date_of_birth = findViewById(R.id.user_date_of_birth);
        user_team = findViewById(R.id.user_team);
        user_zone = findViewById(R.id.user_zone);
        ViewPager viewPager = findViewById(R.id.player_details_viewpager);
        playerDetailsPresenterClass = new PlayerDetailsPresenterClass(this, this);
        if (getIntent() != null) {

            age = getIntent().getStringExtra("AGE");
            teamName = getIntent().getStringExtra("TEAM_NAME");
            divisionName = getIntent().getStringExtra("DIVISION_NAME");
            playerId = getIntent().getStringExtra("PLAYER_ID");
            playerName = getIntent().getStringExtra("PLAYER_NAME");
            title.setText(playerName != null ? playerName : "");

            playerDetailsPresenterClass.giveDate(age);
            String defaultToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvc3RhZ2luZy5vc2RiLnBybzo4MVwvYXBpXC92MVwvbG9naW4iLCJpYXQiOjE1NTIzNzA2OTYsImV4cCI6MTU1MjgwMjY5NiwibmJmIjoxNTUyMzcwNjk2LCJqdGkiOiJERUpQVTN2cnZBZEIyQzZrIiwic3ViIjozNjIsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.IrSsXMjW-BWKhrfFuEMCiitdVS_ijN6bFBvfsE2_Cjk";
            String token = getAppPreferenceHelperClass().getToken() != null ? getAppPreferenceHelperClass().getToken() : defaultToken;

//            playerDetailsPresenterClass.getPlayerID(playerId, this , token);

            user_team.setText(teamName);
            user_zone.setText(divisionName);

        }


        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);

        setDividerForTabs();

        backBtn.setOnClickListener(this);
        followBtn.setOnClickListener(this);
    }

    private void setupViewPager(ViewPager upViewPager) {
        LatestViewPagerFragment adapter = new LatestViewPagerFragment(getSupportFragmentManager());
        adapter.addFragment(InfoFragment.getInstance(), getString(R.string.info));
        adapter.addFragment(CareerFragment.getInstance(), getString(R.string.career));
        adapter.addFragment(BioFragment.getInstance(), getString(R.string.bio));
        adapter.addFragment(NewsFragment.getInstance(), getString(R.string.news));
        adapter.addFragment(StatsFragment.getInstance(), getString(R.string.stats));
        adapter.addFragment(VideosFragment.getInstance(), getString(R.string.videos));
        adapter.addFragment(PhotosFragment.getInstance(), getString(R.string.photos));
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


    @Override
    public void formattedDate(String stringDate) {
        user_date_of_birth.setText(stringDate);
    }

    @Override
    public void playersAge(String stringDate) {
        user_age.setText(stringDate);
    }

    @Override
    public void fetchPlayerDetailInfo(PlayerDetailInfoBean jsonObject) {
        this.playerDetailInfoBean = jsonObject;
    }

    @Override
    public void errorOccur(String error) {

    }
}
