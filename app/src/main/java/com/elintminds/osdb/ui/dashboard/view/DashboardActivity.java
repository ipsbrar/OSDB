package com.elintminds.osdb.ui.dashboard.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
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

import java.util.Objects;

public class DashboardActivity extends BaseActivity implements DashboardView, View.OnClickListener {

    private TextView mTextMessage;
    private Toolbar toolbar;

    private LinearLayout home_lay, latest_lay;
    private String currentFrag = "Home";
    private ImageView homelogo;

    private MenuItem searchItem, calendarItem, addItem;
    private ImageView tabHomeIcon, tabLatestIcon, tabliveIcon, tabPollIcon, tabDiscussionIcon;
    private TextView tabHomeTxt, tabLatestTxt, tabliveTxt, tabPollTxt, tabDiscussionTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initialzeViews();
        //initTab();
        //  getSupportFragmentManager().beginTransaction().add(R.id.dashboard_container, HomeFragment.newInstance()).commit();
        homeSelected();
        changeFragment(HomeFragment.newInstance(), HomeFragment.TAG);
    }

    private void initialzeViews() {
        toolbar = findViewById(R.id.dashboard_toolbar);
        mTextMessage = findViewById(R.id.dashboard_title);
        homelogo = findViewById(R.id.home_logo);
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

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        searchItem = menu.findItem(R.id.navigation_search);
        calendarItem = menu.findItem(R.id.navigation_calendar);
        addItem = menu.findItem(R.id.navigation_add);
        switch (Objects.requireNonNull(getCurrentFragment().getTag())) {
            case HomeFragment.TAG:
                searchItem.setVisible(true);
                calendarItem.setVisible(false);
                addItem.setVisible(false);
                invalidateOptionsMenu();
                break;
            case LatestFragment.TAG:
                searchItem.setVisible(true);
                calendarItem.setVisible(false);
                addItem.setVisible(false);
                invalidateOptionsMenu();
                break;
            case LiveScroresFragment.TAG:
                searchItem.setVisible(false);
                calendarItem.setVisible(false);
                addItem.setVisible(false);
                invalidateOptionsMenu();
                break;
            case PollFragment.TAG:
                searchItem.setVisible(false);
                calendarItem.setVisible(true);
                addItem.setVisible(false);
                invalidateOptionsMenu();
                break;

            case DiscussionFragment.TAG:
                searchItem.setVisible(false);
                calendarItem.setVisible(false);
                addItem.setVisible(true);
                invalidateOptionsMenu();
                break;

            default:
                searchItem.setVisible(true);
                calendarItem.setVisible(false);
                addItem.setVisible(false);
                invalidateOptionsMenu();
                break;
        }


        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);

        return true;
    }

    public Fragment getCurrentFragment() {

        return getSupportFragmentManager().findFragmentById(R.id.dashboard_container);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_search:
                startActivity(new Intent(this, SearchActivity.class));
                break;
            case R.id.navigation_add:
                startActivity(new Intent(this, AddEditDiscussionActivity.class));
                return true;
            case R.id.navigation_calendar:
                startActivity(new Intent(this, PollCalendarActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }


    public void changeFragment(Fragment fragment, String tag) {
        toolbarMenuVisibility(tag);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.dashboard_container, fragment, tag)
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
                changeFragment(HomeFragment.newInstance(), HomeFragment.TAG);
                break;
            }

            case R.id.latest_lay: {

                latestSelected();
                mTextMessage.setText(R.string.title_latest);
                changeFragment(LatestFragment.newInstance(), LatestFragment.TAG);
                break;
            }

            case R.id.live_scores_lay:

                liveSelected();
                mTextMessage.setText(R.string.title_live_scores);
                changeFragment(LiveScroresFragment.newInstance(), LiveScroresFragment.TAG);

                break;
            case R.id.polls_lay:

                pollsSelected();
                mTextMessage.setText(R.string.title_poll);
                changeFragment(PollFragment.newInstance(), PollFragment.TAG);
                break;
            case R.id.discussion_lay:

                discussionSelected();
                mTextMessage.setText(R.string.title_discussion);
                changeFragment(DiscussionFragment.newInstance(), DiscussionFragment.TAG);
                break;

        }
    }


    private void homeSelected() {
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


}
