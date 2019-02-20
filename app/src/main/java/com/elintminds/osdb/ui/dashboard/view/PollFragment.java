package com.elintminds.osdb.ui.dashboard.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.dashboard.adapters.PollAdapter;
import com.elintminds.osdb.ui.dashboard.beans.PollAdapterBean;

import java.util.ArrayList;

public class PollFragment extends BaseFragment implements DashboardView.PollOptionListner {

    public static final String TAG = "PollFragment";

    private Context context;
    private RecyclerView pollRecyclerView;
    private PollAdapter pollAdapter;
    private ArrayList<PollAdapterBean> pollList = new ArrayList<>();

    public static PollFragment newInstance() {
        return new PollFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.poll_fragment_view, container, false);
    }

    @Override
    protected void setUp(View view) {
        context = getContext();
        pollRecyclerView = view.findViewById(R.id.poll_recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        pollRecyclerView.setLayoutManager(llm);
        getpollData();
        pollAdapter = new PollAdapter(context, pollList, this);
        pollRecyclerView.setAdapter(pollAdapter);

    }

    private void getpollData() {
        String[] list = getResources().getStringArray(R.array.sports_names);
        for (String name : list) {
            PollAdapterBean item = new PollAdapterBean();
            item.setTitle(name);
            item.setVisible(false);
            ArrayList<String> pollOptionList = new ArrayList<>();
            pollOptionList.add("A");
            item.setPollOptions(pollOptionList);
            pollList.add(item);
        }


    }

    @Override
    public void onOptionClick(int listPosition, int optionPosition) {

        pollList.get(listPosition).setVisible(true);
        pollAdapter.notifyDataSetChanged();

    }
}
