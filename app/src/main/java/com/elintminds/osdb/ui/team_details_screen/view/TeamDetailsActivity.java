package com.elintminds.osdb.ui.team_details_screen.view;

import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.dashboard.adapters.LatestViewPagerFragment;
import com.elintminds.osdb.ui.dashboard.view.NewsFragment;

public class TeamDetailsActivity extends BaseActivity implements TeamDetailsView, View.OnClickListener
{
    private TabLayout tabs;
    private TextView title, followBtn;
    private ImageView backBtn;
    private boolean isFollowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details);

        initializeViews();

        String titleText = getIntent().getStringExtra("TITLE");
        title.setText(titleText);
    }


    private void initializeViews()
    {
        title = findViewById(R.id.teamName);
        tabs = findViewById(R.id.team_details_tabs);
        backBtn = findViewById(R.id.back_btn);
        followBtn = findViewById(R.id.follow_btn);
        ViewPager viewPager = findViewById(R.id.team_details_viewpager);

        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);

        setDividerForTabs();

        backBtn.setOnClickListener(this);
        followBtn.setOnClickListener(this);
    }

    private void setupViewPager(ViewPager upViewPager)
    {
        LatestViewPagerFragment adapter = new LatestViewPagerFragment(getSupportFragmentManager());
        adapter.addFragment(NewsFragment.getInstance(), getString(R.string.news));
        adapter.addFragment(StatsFragment.getInstance(), getString(R.string.stats));
        adapter.addFragment(TeamPlayersFragment.getInstance(), getString(R.string.players));
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
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.back_btn:
                onBackPressed();
                break;

            case R.id.follow_btn:
                isFollowing = !isFollowing;
                followBtn.setSelected(isFollowing);
                if(isFollowing)
                {
                    followBtn.setText(getString(R.string.following));
                }
                else {
                    followBtn.setText(getString(R.string.follow));
                }
                break;
        }
    }
}
