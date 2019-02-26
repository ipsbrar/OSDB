package com.elintminds.osdb.ui.dashboard.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.add_edit_discussion.view.AddEditDiscussionActivity;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.calendar_screen.view.PollCalendarActivity;
import com.elintminds.osdb.ui.search_screen.view.SearchActivity;

import java.util.Objects;

public class DashboardActivity extends BaseActivity implements DashboardView {

    private TextView mTextMessage;
    private Toolbar toolbar;
    private String currentFrag = "Home";
    private ImageView homelogo;
    private int[] mTabIcons = {
            R.drawable.home_icon,
            R.drawable.latest_icon_selctor,
            R.drawable.live_icon_selector,
            R.drawable.poll_icon_selector,
            R.drawable.discussion_icon_selector};
    private int[] mTabnames = {
            R.string.title_home,
            R.string.title_latest,
            R.string.title_live_scores,
            R.string.title_poll,
            R.string.title_discussion};

    private int[] mTabColor = {
            R.color.home_color,
            R.color.latest_color,
            R.color.live_color,
            R.color.poll_color,
            R.color.discussion_color};
    private MenuItem searchItem, calendarItem, addItem;

    private String[] TABS;
    private TabLayout bottomTabLayout;

    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initialzeViews();
        initTab();
        //  getSupportFragmentManager().beginTransaction().add(R.id.dashboard_container, HomeFragment.newInstance()).commit();

        switchTab(0);
    }

    private void initialzeViews() {
        toolbar = findViewById(R.id.dashboard_toolbar);
        mTextMessage = findViewById(R.id.dashboard_title);
        homelogo = findViewById(R.id.home_logo);
        bottomTabLayout = findViewById(R.id.navigation);
        bottomTabLayout.setSelectedTabIndicator(0);
        TABS = getResources().getStringArray(R.array.tab_names);
        setSupportActionBar(toolbar);

        bottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                switchTab(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


                switchTab(tab.getPosition());


            }
        });

    }

    private void initTab() {
        if (bottomTabLayout != null) {
            for (int i = 0; i < TABS.length; i++) {
                bottomTabLayout.addTab(bottomTabLayout.newTab());

                TabLayout.Tab tab = bottomTabLayout.getTabAt(i);
                if (tab != null)
                    tab.setCustomView(getTabView(i));
            }
        }
    }

    private View getTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_item_bottom, null);
        icon = (ImageView) view.findViewById(R.id.tab_icon);
        TextView tabname = (TextView) view.findViewById(R.id.tab_name);
        icon.setImageResource(mTabIcons[position]);
        tabname.setText(mTabnames[position]);
        tabname.setTextColor(getResources().getColorStateList(mTabColor[position]));

        return view;
    }


    private void switchTab(int position) {
        //   invalidateOptionsMenu();
        switch (position) {
            case 0:
                changeFragment(HomeFragment.newInstance(), HomeFragment.TAG);

                break;

            case 1:
                mTextMessage.setText(R.string.title_latest);
                changeFragment(LatestFragment.newInstance(), LatestFragment.TAG);

                break;
            case 2:
                mTextMessage.setText(R.string.title_live_scores);

                changeFragment(LiveScroresFragment.newInstance(), LiveScroresFragment.TAG);

                break;
            case 3:
                mTextMessage.setText(R.string.title_poll);

                changeFragment(PollFragment.newInstance(), PollFragment.TAG);
                break;
            case 4:
                mTextMessage.setText(R.string.title_discussion);

                changeFragment(DiscussionFragment.newInstance(), DiscussionFragment.TAG);
                break;

        }
//        updateToolbarTitle(position);
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

}
