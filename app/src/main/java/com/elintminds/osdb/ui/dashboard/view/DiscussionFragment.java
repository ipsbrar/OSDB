package com.elintminds.osdb.ui.dashboard.view;

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
import com.elintminds.osdb.ui.dashboard.adapters.DiscussionAdapter;
import com.elintminds.osdb.ui.dashboard.adapters.DiscussionAdapterBean;

import java.util.ArrayList;

public class DiscussionFragment extends BaseFragment {
    public static final String TAG = "DiscussionFragment";
    private ArrayList<DiscussionAdapterBean> discussionList = new ArrayList<>();
    private DiscussionAdapter discussionAdapter;

    public static DiscussionFragment newInstance() {
        return new DiscussionFragment();
    }

    @Override
    protected void setUp(View view) {

        RecyclerView discussionRecyclerView = view.findViewById(R.id.disccusion_recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        discussionRecyclerView.setLayoutManager(llm);
        discussionAdapter = new DiscussionAdapter(getContext(), discussionList);
        discussionRecyclerView.setAdapter(discussionAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dashboard_fragment_view, container, false);
    }

}
