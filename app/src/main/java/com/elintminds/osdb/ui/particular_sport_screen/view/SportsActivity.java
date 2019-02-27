package com.elintminds.osdb.ui.particular_sport_screen.view;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.dashboard.adapters.LatestViewPagerFragment;
import com.elintminds.osdb.ui.dashboard.view.NewsFragment;
import com.elintminds.osdb.ui.search_finding_screen.view.ScheduleFragment;
import com.elintminds.osdb.ui.search_screen.view.SearchActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class SportsActivity extends BaseActivity implements SportScreenView, View.OnClickListener {

    private Toolbar toolbar;
    private TabLayout tabs;
    private TextView title;
    private PopupWindow dropdownMenu;
    private ArrayList<String> dropdownList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        initializeViews();

        int selectedSport = getIntent().getIntExtra("SPORT_ID", -1);
        Log.e("SPORT_ID",""+selectedSport);
        title.setText(dropdownList.get(selectedSport));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initializeViews()
    {
        title = findViewById(R.id.sport_screen_title);
        toolbar = findViewById(R.id.sport_screen_toolbar);
        tabs = findViewById(R.id.sport_screen_tabs);
        ViewPager viewPager = findViewById(R.id.sport_screen_viewpager);

        dropdownList.addAll(Arrays.asList(getResources().getStringArray(R.array.sports_names)));

        setSupportActionBar(toolbar);

        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);

        setDividerForTabs();

        title.setOnClickListener(this);
    }

    private void setupViewPager(ViewPager upViewPager)
    {
        Bundle args = new Bundle();
        args.putInt("SCHEDULES", 5);

        LatestViewPagerFragment adapter = new LatestViewPagerFragment(getSupportFragmentManager());
        adapter.addFragment(NewsFragment.getInstance(), getString(R.string.news));
        adapter.addFragment(TeamsFragment.getInstance(), getString(R.string.teams));
        adapter.addFragment(ScheduleFragment.getInstance(args), getString(R.string.schedule));
        upViewPager.setAdapter(adapter);
    }

    private void setDividerForTabs()
    {
        View root = tabs.getChildAt(0);
        if (root instanceof LinearLayout)
        {
            ((LinearLayout) root).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(getResources().getColor(R.color.color_EFEFEF));
            drawable.setSize(2, 1);
            ((LinearLayout) root).setDividerPadding(0);
            ((LinearLayout) root).setDividerDrawable(drawable);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_search:
                startActivity(new Intent(this, SearchActivity.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.sport_screen_title:
                dropdownMenu = optionsPopupView(dropdownList);
                dropdownMenu.showAsDropDown(title, 0, 20);
                break;
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private PopupWindow optionsPopupView(ArrayList<String> items){
        final PopupWindow popupWindow = new PopupWindow();
        LayoutInflater inflater = LayoutInflater.from(this);
        View popupView = inflater.inflate(R.layout.popup_menu_layout, toolbar, false);
        popupWindow.setFocusable(true);
        popupWindow.setWidth(ListPopupWindow.MATCH_PARENT);
        popupWindow.setHeight(ListPopupWindow.WRAP_CONTENT);
        popupWindow.setContentView(popupView);
        popupWindow.setElevation(2f);
        ListView popupList = popupView.findViewById(R.id.popup_list);
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.simple_list_item, items);
        popupList.setAdapter(adapter);

        popupList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                title.setText(dropdownList.get(i));
                popupWindow.dismiss();
            }
        });

        popupWindow.setOutsideTouchable(true);

        return popupWindow;
    }
}
