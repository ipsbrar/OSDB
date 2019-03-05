package com.elintminds.osdb.ui.dashboard.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.dashboard.adapters.PollAdapter;
import com.elintminds.osdb.ui.dashboard.beans.PollAdapterBean;
import com.elintminds.osdb.ui.dashboard.presenter.PollsPresenterClass;

import java.util.ArrayList;

public class PollFragment extends BaseFragment implements DashboardView.PollOptionListner, PollView {

    public static final String TAG = "PollFragment";

    private Context context;
    private ShimmerRecyclerView pollRecyclerView;
    private PollAdapter pollAdapter;
    public static TextView dateTxt;
    private ArrayList<PollAdapterBean> pollList = new ArrayList<>();
    private PollsPresenterClass<PollFragment, com.elintminds.osdb.ui.dashboard.model.PollsInteractor> pollsPresenterClass;

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
        pollsPresenterClass = new PollsPresenterClass<PollFragment, com.elintminds.osdb.ui.dashboard.model.PollsInteractor>(context, this);
        pollRecyclerView = view.findViewById(R.id.poll_recycler_view);
        dateTxt = view.findViewById(R.id.date_txt);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        pollRecyclerView.setLayoutManager(llm);


        pollsPresenterClass.getPollsData("2019-02-23", "2");

//        pollsPresenterClass.getPollsData(AppConstants.getCurrentDate(), "2");
        pollAdapter = new PollAdapter(context, pollList, this);
        pollRecyclerView.setAdapter(pollAdapter);
        pollRecyclerView.showShimmerAdapter();

    }

    private void getpollData() {


//        PollAdapterBean item = new PollAdapterBean();
//        item.setTitle("The new BFL starts this weekend. The MFL starts right after in February. What do you think?");
//
//        ArrayList<PollOption> pollOptionList = new ArrayList<>();
//
//        PollOption pollOption = new PollOption();
//        pollOption.setPollOptions("More football is better!");
//        pollOption.setPollLabel("A");
//        pollOptionList.add(pollOption);
//        PollOption pollOption1 = new PollOption();
//        pollOption1.setPollOptions("Backt-to-back leagues? That’s too much!");
//        pollOption1.setPollLabel("B");
//        pollOptionList.add(pollOption1);
//
//        item.setPollOptions(pollOptionList);
//        item.setVisible(false);
//        pollList.add(item);
//
//        ArrayList<PollOption> pollOptionList2 = new ArrayList<>();
//        PollAdapterBean item2 = new PollAdapterBean();
//        item2.setTitle("What sport delivers the hardest hits?");
//
//        PollOption pollOption2 = new PollOption();
//        pollOption2.setPollOptions("Rugby");
//        pollOption2.setPollLabel("A");
//        pollOptionList2.add(pollOption2);
//        PollOption pollOption3 = new PollOption();
//        pollOption3.setPollOptions("Football");
//        pollOption3.setPollLabel("B");
//        pollOptionList2.add(pollOption3);
//        item2.setPollOptions(pollOptionList2);
//        item2.setVisible(false);
//        pollList.add(item2);

    }

    @Override
    public void onOptionClick(int listPosition, int optionPosition) {

//        pollList.get(listPosition).setVisible(true);
//        pollAdapter.notifyDataSetChanged();

    }

    @Override
    public void getPollData(ArrayList<PollAdapterBean> arrayList) {

        pollRecyclerView.hideShimmerAdapter();
        pollList.addAll(arrayList);
        pollAdapter.notifyDataSetChanged();

    }
}
