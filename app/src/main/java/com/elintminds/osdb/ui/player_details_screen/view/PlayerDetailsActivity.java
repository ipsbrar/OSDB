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
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.dashboard.adapters.LatestViewPagerFragment;
import com.elintminds.osdb.ui.dashboard.view.NewsFragment;
import com.elintminds.osdb.ui.player_details_screen.beans.PlayerDetailInfoBean;
import com.elintminds.osdb.ui.player_details_screen.beans.VideosBean;
import com.elintminds.osdb.ui.player_details_screen.presenter.PlayerDetailsPresenterClass;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsBeanVertical;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsBeans;
import com.elintminds.osdb.ui.team_details_screen.view.StatsFragment;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;


public class PlayerDetailsActivity extends BaseActivity implements PlayerDetailsView, View.OnClickListener {
    private TabLayout tabs;
    private TextView title, followBtn, user_age, user_date_of_birth, user_team, user_zone;
    private CircleImageView user_Image;
    private ImageView backBtn;
    private boolean isFollowing = false;
    private String age, teamName, divisionName, playerId, playerName, profilePic, dateOfBirth, clubName;
    private PlayerDetailsPresenterClass playerDetailsPresenterClass;
    private PlayerDetailInfoBean playerDetailInfoBean;
    private ArrayList<String> careerHeightArray = new ArrayList<>();
    private ArrayList<String> imageListArray = new ArrayList<>();
    private ArrayList<VideosBean> videosBeanArrayList = new ArrayList<>();
    private ViewPager viewPager;
    private String bio;
    private ArrayList<StatsBeanVertical> statsBeanVerticalArrayList = new ArrayList<>();

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
        user_Image = findViewById(R.id.user_Image);
        followBtn = findViewById(R.id.follow_btn);
        user_age = findViewById(R.id.user_age);
        user_date_of_birth = findViewById(R.id.user_date_of_birth);
        user_team = findViewById(R.id.user_team);
        user_zone = findViewById(R.id.user_zone);
        viewPager = findViewById(R.id.player_details_viewpager);
        viewPager.setOffscreenPageLimit(7);
        playerDetailsPresenterClass = new PlayerDetailsPresenterClass(this, this);
        if (getIntent() != null) {

            age = getIntent().getStringExtra("AGE");
            profilePic = getIntent().getStringExtra("PROFILE_PIC");
            teamName = getIntent().getStringExtra("TEAM_NAME");
            divisionName = getIntent().getStringExtra("DIVISION_NAME");
            playerId = getIntent().getStringExtra("PLAYER_ID");
            playerName = getIntent().getStringExtra("PLAYER_NAME");
            clubName = getIntent().getStringExtra("CLUB_NAME");
            dateOfBirth = getIntent().getStringExtra("dateOfBirth");

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.img_player_empty);
            if (profilePic != null)
                Glide.with(this).setDefaultRequestOptions(requestOptions).load(profilePic).into(user_Image);
            title.setText(playerName != null ? playerName : "");

            playerDetailsPresenterClass.giveDate(age);
            String defaultToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvc3RhZ2luZy5vc2RiLnBybzo4MVwvYXBpXC92MVwvbG9naW4iLCJpYXQiOjE1NTIzNzA2OTYsImV4cCI6MTU1MjgwMjY5NiwibmJmIjoxNTUyMzcwNjk2LCJqdGkiOiJERUpQVTN2cnZBZEIyQzZrIiwic3ViIjozNjIsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.IrSsXMjW-BWKhrfFuEMCiitdVS_ijN6bFBvfsE2_Cjk";
            String token = getAppPreferenceHelperClass().getToken() != null ? getAppPreferenceHelperClass().getToken() : defaultToken;

            playerDetailsPresenterClass.getPlayerID(playerId, this, token);

            user_team.setText(teamName);
            user_zone.setText(clubName);

        }


        backBtn.setOnClickListener(this);
        followBtn.setOnClickListener(this);
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
        if (dateOfBirth != null)
            user_age.setText(dateOfBirth);
        else
            user_age.setText(stringDate);
    }

    @Override
    public void fetchPlayerDetailInfo(PlayerDetailInfoBean jsonObject,
                                      ArrayList<String> careerHeightsArray,
                                      ArrayList<String> imageListArray,
                                      ArrayList<VideosBean> videosBeanArrayList,
                                      String bio,
                                      ArrayList<StatsBeanVertical> statsBeanVerticalArrayList) {
        this.playerDetailInfoBean = jsonObject;
        this.careerHeightArray = careerHeightsArray;
        this.imageListArray = imageListArray;
        this.videosBeanArrayList = videosBeanArrayList;
        this.bio = bio;
        this.statsBeanVerticalArrayList = statsBeanVerticalArrayList;
        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);

        setDividerForTabs();
    }


    @Override
    public void errorOccur(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);
        setDividerForTabs();

    }

    private void setupViewPager(ViewPager upViewPager) {
        LatestViewPagerFragment adapter = new LatestViewPagerFragment(getSupportFragmentManager());
        adapter.addFragment(InfoFragment.getInstance(playerDetailInfoBean), getString(R.string.info));
        adapter.addFragment(CareerFragment.getInstance(careerHeightArray), getString(R.string.career));
        adapter.addFragment(BioFragment.getInstance(bio), getString(R.string.bio));
        adapter.addFragment(NewsFragment.getInstance(), getString(R.string.news));
        adapter.addFragment(StatsFragment.getInstance(statsBeanVerticalArrayList, null), getString(R.string.stats));
        adapter.addFragment(VideosFragment.getInstance(videosBeanArrayList), getString(R.string.videos));
        adapter.addFragment(PhotosFragment.getInstance(imageListArray), getString(R.string.photos));
        upViewPager.setAdapter(adapter);
    }
}
