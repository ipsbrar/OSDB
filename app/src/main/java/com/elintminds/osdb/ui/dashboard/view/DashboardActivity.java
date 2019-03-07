package com.elintminds.osdb.ui.dashboard.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.add_edit_discussion.view.AddEditDiscussionActivity;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.calendar_screen.view.PollCalendarActivity;
import com.elintminds.osdb.ui.profile.view.ProfileActivity;
import com.elintminds.osdb.ui.search_screen.view.SearchActivity;

import java.util.ArrayList;

public class DashboardActivity extends BaseActivity implements DashboardView, View.OnClickListener {

    private TextView mTextMessage;
    private Toolbar toolbar;

    private LinearLayout home_lay, latest_lay;
    private String currentFrag = "Home";
    private ImageView homelogo;
    private ImageView optionMenuImg;

    private MenuItem searchItem, calendarItem, addItem;
    private ImageView tabHomeIcon, tabLatestIcon, tabliveIcon, tabPollIcon, tabDiscussionIcon;
    private TextView tabHomeTxt, tabLatestTxt, tabliveTxt, tabPollTxt, tabDiscussionTxt;

    private ArrayList<String> tags = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initialzeViews();
        //initTab();
        //  getSupportFragmentManager().beginTransaction().add(R.id.dashboard_container, HomeFragment.newInstance()).commit();
        homeSelected();
        changeFragment(HomeFragment.newInstance(), HomeFragment.TAG);
        if (!tags.contains(HomeFragment.TAG)) {
            tags.add(HomeFragment.TAG);
        }

    }

    private void initialzeViews() {
        toolbar = findViewById(R.id.dashboard_toolbar);
        mTextMessage = findViewById(R.id.dashboard_title);
        homelogo = findViewById(R.id.home_logo);
        optionMenuImg = findViewById(R.id.option_img);
        optionMenuImg.setOnClickListener(this);
        findViewById(R.id.home_lay).setOnClickListener(this);
        findViewById(R.id.latest_lay).setOnClickListener(this);
        findViewById(R.id.live_scores_lay).setOnClickListener(this);
        findViewById(R.id.polls_lay).setOnClickListener(this);
        findViewById(R.id.discussion_lay).setOnClickListener(this);

        tabHomeIcon = findViewById(R.id.tab_icon_home);
        tabLatestIcon = findViewById(R.id.tab_icon_latest);
        tabliveIcon = findViewById(R.id.tab_icon_live);
        tabPollIcon = findViewById(R.id.tab_icon_polls);
        tabDiscussionIcon = findViewById(R.id.tab_icon_discussion);

        tabHomeTxt = findViewById(R.id.tab_name_home);
        tabLatestTxt = findViewById(R.id.tab_name_latest);
        tabliveTxt = findViewById(R.id.tab_name_live);
        tabPollTxt = findViewById(R.id.tab_name_polls);
        tabDiscussionTxt = findViewById(R.id.tab_name_discussion);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, ProfileActivity.class));
            }
        });
    }


    public Fragment getCurrentFragment() {

        return getSupportFragmentManager().findFragmentById(R.id.dashboard_container);
    }


    public void changeFragment(Fragment fragment, String tag) {
        toolbarMenuVisibility(tag);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.dashboard_container, fragment, tag)
                .commit();
    }


    public void toolbarMenuVisibility(String tag) {
        if (tag.equals(HomeFragment.TAG)) {
            mTextMessage.setVisibility(View.GONE);
            homelogo.setVisibility(View.VISIBLE);
        } else {
            mTextMessage.setVisibility(View.VISIBLE);
            homelogo.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.home_lay: {
                homeSelected();
                showFragment(HomeFragment.newInstance(), HomeFragment.TAG);
                //changeFragment(HomeFragment.newInstance(), HomeFragment.TAG);

                break;
            }

            case R.id.latest_lay: {

                latestSelected();
                mTextMessage.setText(R.string.title_latest);

                showFragment(LatestFragment.newInstance(), LatestFragment.TAG);
                //  changeFragment(LatestFragment.newInstance(), LatestFragment.TAG);
                break;
            }

            case R.id.live_scores_lay:

                liveSelected();
                mTextMessage.setText(R.string.title_live_scores);
                //changeFragment(LiveScroresFragment.newInstance(), LiveScroresFragment.TAG);
                showFragment(LiveScroresFragment.newInstance(), LiveScroresFragment.TAG);

                break;
            case R.id.polls_lay:

                pollsSelected();
                mTextMessage.setText(R.string.title_poll);
                showFragment(PollFragment.newInstance(), PollFragment.TAG);
                break;
            case R.id.discussion_lay:

                discussionSelected();
                mTextMessage.setText(R.string.title_discussion);
                showFragment(DiscussionFragment.newInstance(), DiscussionFragment.TAG);
                break;

            case R.id.option_img:

                optionClick(getCurrentFragment().getTag());
                break;

        }
    }

    private void optionClick(String tag) {

        switch (tag) {
            case HomeFragment.TAG:

                startActivity(new Intent(this, SearchActivity.class));
                break;
            case LatestFragment.TAG:
                startActivity(new Intent(this, SearchActivity.class));
                break;
            case LiveScroresFragment.TAG:

                break;
            case PollFragment.TAG:
                startActivity(new Intent(this, PollCalendarActivity.class));
                break;

            case DiscussionFragment.TAG:
                startActivity(new Intent(this, AddEditDiscussionActivity.class));
                break;

            default:
                startActivity(new Intent(this, SearchActivity.class));
                break;
        }
    }


    private void homeSelected() {
        optionMenuImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_search));
        tabHomeIcon.setSelected(true);
        tabHomeTxt.setSelected(true);

        tabLatestIcon.setSelected(false);
        tabLatestTxt.setSelected(false);

        tabliveIcon.setSelected(false);
        tabliveTxt.setSelected(false);

        tabPollIcon.setSelected(false);
        tabPollIcon.setSelected(false);

        tabDiscussionIcon.setSelected(false);
        tabDiscussionTxt.setSelected(false);
    }

    private void latestSelected() {
        optionMenuImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_search));
        tabHomeIcon.setSelected(false);
        tabHomeTxt.setSelected(false);

        tabLatestIcon.setSelected(true);
        tabLatestTxt.setSelected(true);

        tabliveIcon.setSelected(false);
        tabliveTxt.setSelected(false);

        tabPollIcon.setSelected(false);
        tabPollIcon.setSelected(false);

        tabDiscussionIcon.setSelected(false);
        tabDiscussionTxt.setSelected(false);
    }

    private void liveSelected() {
        optionMenuImg.setImageDrawable(null);
        tabHomeIcon.setSelected(false);
        tabHomeTxt.setSelected(false);

        tabLatestIcon.setSelected(false);
        tabLatestTxt.setSelected(false);

        tabliveIcon.setSelected(true);
        tabliveTxt.setSelected(true);

        tabPollIcon.setSelected(false);
        tabPollIcon.setSelected(false);

        tabDiscussionIcon.setSelected(false);
        tabDiscussionTxt.setSelected(false);
    }

    private void pollsSelected() {
        optionMenuImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_calendar));
        tabHomeIcon.setSelected(false);
        tabHomeTxt.setSelected(false);

        tabLatestIcon.setSelected(false);
        tabLatestTxt.setSelected(false);

        tabliveIcon.setSelected(false);
        tabliveTxt.setSelected(false);

        tabPollIcon.setSelected(true);
        tabPollIcon.setSelected(true);

        tabDiscussionIcon.setSelected(false);
        tabDiscussionTxt.setSelected(false);
    }

    private void discussionSelected() {
        optionMenuImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_add));
        tabHomeIcon.setSelected(false);
        tabHomeTxt.setSelected(false);

        tabLatestIcon.setSelected(false);
        tabLatestTxt.setSelected(false);

        tabliveIcon.setSelected(false);
        tabliveTxt.setSelected(false);

        tabPollIcon.setSelected(false);
        tabPollIcon.setSelected(false);

        tabDiscussionIcon.setSelected(true);
        tabDiscussionTxt.setSelected(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    private void showFragment(Fragment frag, String tag) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (tags.contains(tag)) {
            fragmentManager.beginTransaction().show(fragmentManager.findFragmentByTag(tag)).commit();
        } else {

            tags.add(tag);
            fragmentManager.beginTransaction().add(R.id.dashboard_container, frag, tag).commit();
        }
        for (String tagStr : tags) {
            Log.e("Tags", tagStr);
            if (!tagStr.equals(tag)) {
                fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag(tagStr)).commit();
            }
        }


    }
}
