package com.elintminds.osdb.ui.particular_sport_screen.view;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
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
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;
import com.elintminds.osdb.ui.dashboard.view.NewsFragment;
import com.elintminds.osdb.ui.particular_sport_screen.adapters.DropDownAdapter;
import com.elintminds.osdb.ui.particular_sport_screen.beans.DropdownBean;
import com.elintminds.osdb.ui.search_finding_screen.view.ScheduleFragment;
import com.elintminds.osdb.ui.search_screen.view.SearchActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class SportsActivity extends BaseActivity implements SportScreenView, View.OnClickListener {

    private Toolbar toolbar;
    private TabLayout tabs;
    private TextView title;
    private PopupWindow dropdownMenu;
    private ArrayList<SportsAdapterListBean> dropdownList = new ArrayList<>();
    private String sportsName;
    private int selectedSport;
    public static TeamFragData teamFragData;
    private RelativeLayout rl_main_layout;
    private ConstraintLayout constMainLayout;
    private ImageView img_coming_soon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        if (getIntent() != null) {
            selectedSport = getIntent().getIntExtra("SPORT_ID", 0);
            dropdownList = (ArrayList<SportsAdapterListBean>) getIntent().getSerializableExtra("SPORT_LIST");
            sportsName = getIntent().getStringExtra("SPORT_NAME");
            rl_main_layout = findViewById(R.id.rl_main_layout);
            constMainLayout = findViewById(R.id.constMainLayout);
            img_coming_soon = findViewById(R.id.img_coming_soon);
            if (sportsName.equalsIgnoreCase("NFL") || sportsName.equalsIgnoreCase("NBA")) {
                rl_main_layout.setVisibility(View.VISIBLE);
                constMainLayout.setVisibility(View.GONE);
            } else {
                rl_main_layout.setVisibility(View.GONE);
                constMainLayout.setVisibility(View.VISIBLE);
                setImageBackground(sportsName);
            }

        }

        initializeViews();

    }

    private void setImageBackground(String sportsName) {
        Log.e("SportsName    ", sportsName);
        if (sportsName.equalsIgnoreCase("Soccer")) {
            img_coming_soon.setImageDrawable(getDrawable(R.drawable.coming_soon_soccer));

        } else if (sportsName.equalsIgnoreCase("NHL")) {
            img_coming_soon.setImageDrawable(getDrawable(R.drawable.coming_soon_nhl));

        } else if (sportsName.equalsIgnoreCase("GOLF")) {
            img_coming_soon.setImageDrawable(getDrawable(R.drawable.coming_soon_golf));

        } else if (sportsName.equalsIgnoreCase("TENNIS")) {
            img_coming_soon.setImageDrawable(getDrawable(R.drawable.coming_soon_tennis));

        } else if (sportsName.equalsIgnoreCase("BOXING")) {
            img_coming_soon.setImageDrawable(getDrawable(R.drawable.coming_soon_boxing));

        } else if (sportsName.equalsIgnoreCase("NASCAR")) {
            img_coming_soon.setImageDrawable(getDrawable(R.drawable.coming_soon_nascar));

        }

    }

    private void initializeViews() {
        title = findViewById(R.id.sport_screen_title);
        title.setText(dropdownList.get(selectedSport).getName());

        toolbar = findViewById(R.id.sport_screen_toolbar);
        tabs = findViewById(R.id.sport_screen_tabs);
        ViewPager viewPager = findViewById(R.id.sport_screen_viewpager);

        setSupportActionBar(toolbar);

        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);

        setDividerForTabs();


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        title.setOnClickListener(this);
    }

    private void setupViewPager(ViewPager upViewPager) {
        Bundle args = new Bundle();
        args.putInt("SCHEDULES", 5);
        args.putString("SLUG", sportsName);

        LatestViewPagerFragment adapter = new LatestViewPagerFragment(getSupportFragmentManager());
        adapter.addFragment(NewsFragment.getInstance(), getString(R.string.news));
        adapter.addFragment(TeamsFragment.getInstance(sportsName), getString(R.string.teams));
        adapter.addFragment(ScheduleFragment.getInstance(args), getString(R.string.schedule));
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
    public boolean onCreateOptionsMenu(Menu menu) {
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sport_screen_title:
                dropdownMenu = optionsPopupView(dropdownList);
                dropdownMenu.showAsDropDown(title, 0, 20);
                break;
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private PopupWindow optionsPopupView(ArrayList<SportsAdapterListBean> items) {
        final PopupWindow popupWindow = new PopupWindow();
        LayoutInflater inflater = LayoutInflater.from(this);
        View popupView = inflater.inflate(R.layout.popup_menu_layout, toolbar, false);
        popupWindow.setFocusable(true);
        popupWindow.setWidth(ListPopupWindow.MATCH_PARENT);
        popupWindow.setHeight(ListPopupWindow.WRAP_CONTENT);
        popupWindow.setContentView(popupView);
        popupWindow.setElevation(2f);
        ListView popupList = popupView.findViewById(R.id.popup_list);
        DropDownAdapter adapter1 = new DropDownAdapter(this, items);
        popupList.setAdapter(adapter1);

        popupList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                title.setText(dropdownList.get(i).getName());
                sportsName = dropdownList.get(i).getName();
                teamFragData.fetchTeamsData(sportsName);
                popupWindow.dismiss();
            }
        });

        popupWindow.setOutsideTouchable(true);

        return popupWindow;
    }

    public void setTeamInterFace(TeamFragData teamInterFace) {
        this.teamFragData = teamInterFace;
    }

    public interface TeamFragData extends Serializable {
        void fetchTeamsData(String sportsName);
    }
}
