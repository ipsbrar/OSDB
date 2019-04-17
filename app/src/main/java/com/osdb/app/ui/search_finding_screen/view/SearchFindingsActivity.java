package com.osdb.app.ui.search_finding_screen.view;

import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.osdb.app.R;
import com.osdb.app.ui.base.view.BaseActivity;
import com.osdb.app.ui.dashboard.adapters.LatestViewPagerFragment;
import com.osdb.app.ui.dashboard.view.NewsFragment;

public class SearchFindingsActivity extends BaseActivity implements SearchFindingView
{

    private Toolbar toolbar;
    private TabLayout tabs;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_findings);

        initializeViews();

        String titleText = getIntent().getStringExtra("TITLE");
        title.setText(titleText);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initializeViews()
    {
        title = findViewById(R.id.search_finding_title);
        toolbar = findViewById(R.id.search_finding_toolbar);
        tabs = findViewById(R.id.search_findings_tabs);
        ViewPager viewPager = findViewById(R.id.search_findings_viewpager);

        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);

        setDividerForTabs();
    }

    private void setupViewPager(ViewPager upViewPager)
    {
        Bundle args = new Bundle();
        args.putInt("SCHEDULES", 1);
        LatestViewPagerFragment adapter = new LatestViewPagerFragment(getSupportFragmentManager());
        adapter.addFragment(NewsFragment.getInstance(null), getString(R.string.news));
        adapter.addFragment(PlayerFragment.getInstance(), getString(R.string.player));
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
}
