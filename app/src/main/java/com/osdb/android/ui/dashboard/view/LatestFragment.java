package com.osdb.android.ui.dashboard.view;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.osdb.android.R;
import com.osdb.android.ui.base.view.BaseFragment;
import com.osdb.android.ui.dashboard.adapters.LatestViewPagerFragment;

public class LatestFragment extends BaseFragment
{
    public static final String TAG = "LatestFragment";

    private TabLayout tabs;

    public static LatestFragment newInstance()
    {
        return new LatestFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.latest_fragment_view, container, false);
    }

    @Override
    protected void setUp(View view)
    {
        tabs = view.findViewById(R.id.latest_tabs);
        tabs.setVisibility(View.GONE);
        ViewPager viewPager = view.findViewById(R.id.latest_viewpager);

        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);

        setDividerForTabs();
    }


    private void setupViewPager(ViewPager upViewPager)
    {
        LatestViewPagerFragment adapter = new LatestViewPagerFragment(getChildFragmentManager());
        adapter.addFragment(NewsFragment.getInstance(), getString(R.string.news));
        adapter.addFragment(EventsFragment.getInstance(), getString(R.string.events));
        upViewPager.setAdapter(adapter);
    }

    private void setDividerForTabs(){
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
}
