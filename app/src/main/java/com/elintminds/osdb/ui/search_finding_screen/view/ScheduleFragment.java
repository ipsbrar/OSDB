package com.elintminds.osdb.ui.search_finding_screen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.particular_sport_screen.view.SportsActivity;
import com.elintminds.osdb.ui.search_finding_screen.adapters.SchedulesAdapter;
import com.elintminds.osdb.ui.search_finding_screen.beans.ScheduleBean;
import com.elintminds.osdb.ui.search_finding_screen.presenter.ScheduleFragmentPresenter;
import com.elintminds.osdb.ui.search_finding_screen.presenter.ScheduleFragmentPresenterClass;

import java.util.ArrayList;

public class ScheduleFragment extends BaseFragment implements ScheduleFragmentView {
    public static final String TAG = "ScheduleFragment";

    private Context context;
    private RecyclerView scheduleRV;
    private SchedulesAdapter adapter;
    private ArrayList<ScheduleBean> dataList = new ArrayList<>();
    private ScheduleFragmentPresenterClass scheduleFragmentPresenterClass;

    public static ScheduleFragment getInstance(Bundle args) {
        ScheduleFragment fragment = new ScheduleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
//        scheduleCount = getArguments().getInt("SCHEDULES");

        scheduleFragmentPresenterClass = new ScheduleFragmentPresenterClass(getActivity(), this);

        if (getArguments() != null) {
            String slug = getArguments().getString("SLUG");
            scheduleFragmentPresenterClass.getSlugName(slug != null ? slug : "NFL");
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.single_recycler_view, container, false);
    }


    @Override
    protected void setUp(View view) {
        context = getContext();
        scheduleRV = view.findViewById(R.id.recycler_view);

    }


    @Override
    public void success(ArrayList<ScheduleBean> scheduleBeanArrayList) {
        this.dataList = scheduleBeanArrayList;
//        adapter.setDataList(this.dataList);
        adapter = new SchedulesAdapter(context, this.dataList);
        scheduleRV.setAdapter(adapter);
    }

    @Override
    public void error(String error) {
        Toast.makeText(context, "" + error, Toast.LENGTH_SHORT).show();
    }
//
//    @Override
//    public void fetchTeamsData(String sportsName) {
//        scheduleFragmentPresenterClass.getSlugName(sportsName != null ? sportsName : "NFL");
//    }
}
