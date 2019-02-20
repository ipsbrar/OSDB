package com.elintminds.osdb.ui.dashboard.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;

public class DashboardActivity extends BaseActivity implements DashboardView {

    private TextView mTextMessage;
    private Toolbar toolbar;
    private String currentFrag = "Home";
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


    String[] TABS;
    TabLayout bottomTabLayout;

    ImageView icon;

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
        bottomTabLayout = findViewById(R.id.navigation);
        bottomTabLayout.setSelectedTabIndicator(0);
        TABS = getResources().getStringArray(R.array.tab_names);

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

        switch (position) {
            case 0:
                mTextMessage.setText(R.string.title_home);
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
               // startActivity(new Intent(DashboardActivity.this, PollCalendarActivity.class));
                break;

        }
//        updateToolbarTitle(position);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.navigation_home:
                mTextMessage.setText(R.string.title_home);
                changeFragment(HomeFragment.newInstance(), HomeFragment.TAG);

                return true;
            case R.id.navigation_latest:
                mTextMessage.setText(R.string.title_latest);
                changeFragment(LiveScroresFragment.newInstance(), LiveScroresFragment.TAG);
                return true;
            case R.id.navigation_live_scores:
                mTextMessage.setText(R.string.title_live_scores);
                return true;
            case R.id.navigation_poll:
                mTextMessage.setText(R.string.title_poll);
                return true;
            case R.id.navigation_discussion:
                mTextMessage.setText(R.string.title_discussion);
                return true;
        }


        return super.onOptionsItemSelected(item);

    }
/*    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    changeFragment(HomeFragment.newInstance(), HomeFragment.TAG);
                    return true;
                case R.id.navigation_latest:
                    mTextMessage.setText(R.string.title_latest);
                    changeFragment(LatestFragment.newInstance(), LatestFragment.TAG);
                    changeFragment(LiveScroresFragment.newInstance(), LiveScroresFragment.TAG);
                    return true;
                case R.id.navigation_live_scores:
                    mTextMessage.setText(R.string.title_live_scores);
                    return true;
                case R.id.navigation_poll:
                    mTextMessage.setText(R.string.title_poll);
                    return true;
                case R.id.navigation_discussion:
                    mTextMessage.setText(R.string.title_discussion);
                    return true;
            }
            return false;
        }
    };*/

    public void changeFragment(Fragment fragment, String tag) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.dashboard_container, fragment, tag)
                .commit();
    }


}
