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
import com.elintminds.osdb.ui.search_finding_screen.adapters.SchedulesAdapter;
import com.elintminds.osdb.ui.search_finding_screen.beans.ScheduleBean;

import java.util.ArrayList;

public class ScheduleFragment extends BaseFragment
{
    public static final String TAG = "ScheduleFragment";

    private Context context;
    private RecyclerView scheduleRV;
    private SchedulesAdapter adapter;
    private ArrayList<ScheduleBean> dataList = new ArrayList<>();
    private int scheduleCount = 0;

    public static ScheduleFragment getInstance(Bundle args)
    {
        ScheduleFragment fragment = new ScheduleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        scheduleCount = getArguments().getInt("SCHEDULES");

        for(int i=0; i<scheduleCount; i++) {
            ScheduleBean item = new ScheduleBean();
            dataList.add(item);
        }
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
        scheduleRV = view.findViewById(R.id.recycler_view);
        setupRecyclerView();
    }

    private void setupRecyclerView()
    {
        adapter = new SchedulesAdapter(context, dataList);
        scheduleRV.setAdapter(adapter);
    }
}
