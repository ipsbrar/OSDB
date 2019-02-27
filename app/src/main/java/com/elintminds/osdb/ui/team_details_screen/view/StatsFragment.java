package com.elintminds.osdb.ui.team_details_screen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.search_finding_screen.adapters.PlayerProfileAdapter;
import com.elintminds.osdb.ui.search_finding_screen.beans.PlayersProfileBean;
import com.elintminds.osdb.ui.search_finding_screen.view.PlayerFragment;

import java.util.ArrayList;

public class StatsFragment extends BaseFragment
{
    public static final String TAG = "StatsFragment";

    private Context context;
    private RecyclerView statsRV;

    public static StatsFragment getInstance()
    {
        return new StatsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.single_recycler_view, container, false);
    }


    @Override
    protected void setUp(View view)
    {
        context = getContext();
        statsRV = view.findViewById(R.id.recycler_view);

        setupRecyclerView();
    }

    private void setupRecyclerView()
    {
    }
}
