package com.elintminds.osdb.ui.search_finding_screen.view;

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

import java.util.ArrayList;

public class PlayerFragment extends BaseFragment
{
    public static final String TAG = "PlayerFragment";

    private Context context;
    private RecyclerView playerRV;
    private PlayerProfileAdapter adapter;
    private ArrayList<PlayersProfileBean> dataList = new ArrayList<>();

    public static PlayerFragment getInstance()
    {
        return new PlayerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.single_recycler_view_2, container, false);
    }


    @Override
    protected void setUp(View view)
    {
        context = getContext();
        playerRV = view.findViewById(R.id.recycler_view);

        setupRecyclerView();
    }

    private void setupRecyclerView()
    {
        PlayersProfileBean item = new PlayersProfileBean();
        item.setPlayerName("Aaron Rodgers");
        dataList.add(item);

        adapter = new PlayerProfileAdapter(context, dataList);
        playerRV.setAdapter(adapter);
    }
}
