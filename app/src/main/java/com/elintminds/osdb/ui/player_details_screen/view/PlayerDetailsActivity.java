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
import com.elintminds.osdb.ui.team_details_screen.view.StatsFragment;

public class PlayerDetailsActivity extends BaseActivity implements PlayerDetailsView, View.OnClickListener
{
    private TabLayout tabs;
    private TextView title, followBtn;
    private ImageView backBtn;
    private boolean isFollowing = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail_screen);

        initializeViews();

        String titleText = getIntent().getStringExtra("TITLE");
        title.setText(titleText);
    }

    private void initializeViews()
    {
        title = findViewById(R.id.player_details_title);
        tabs = findViewById(R.id.player_details_tabs);
        backBtn = findViewById(R.id.back_btn);
        followBtn = findViewById(R.id.follow_btn);
        ViewPager viewPager = findViewById(R.id.player_details_viewpager);

        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);

        setDividerForTabs();

        backBtn.setOnClickListener(this);
        followBtn.setOnClickListener(this);
    }

    private void setupViewPager(ViewPager upViewPager)
    {
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
