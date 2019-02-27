package com.elintminds.osdb.ui.player_details_screen.view;

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
import com.elintminds.osdb.ui.player_details_screen.adapters.CareerAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class CareerFragment extends BaseFragment
{
    public static final String TAG = "CareerFragment";

    private Context context;
    private RecyclerView careerRV;
    private CareerAdapter adapter;
    private ArrayList<String> dataList = new ArrayList<>();

    private String[] sampleAchievement = {"Aaron Rodgers is the NFL's all-time regular season career passer rating leader and is one of two quarterbacks to have a regular season career passer rating of over 100."
            , "Rodgers is fifth all-time in postseason career passer rating, has the best touchdown-to-interception ratio in NFL history at 4.23, holds the league's lowest career interception percentage at 1.5 percent[6] and the highest single-season passer rating record of 122.5."
            , "Due to the fact that Rodgers is the NFL's all-time regular season career passer rating leader, and his overall high level of play"
            , "Jaire Alexander"
            , "Rodgers is considered by some sportscasters and players to be one of the greatest quarterbacks of all time"
            };

    public static CareerFragment getInstance()
    {
        return new CareerFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Collections.addAll(dataList, sampleAchievement);
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
        careerRV = view.findViewById(R.id.recycler_view);

        setupRecyclerView();
    }

    private void setupRecyclerView()
    {
        adapter = new CareerAdapter(context, dataList);
        careerRV.setAdapter(adapter);
    }
}
