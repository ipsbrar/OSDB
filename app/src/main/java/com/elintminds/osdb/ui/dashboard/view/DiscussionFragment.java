package com.elintminds.osdb.ui.dashboard.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseDialogView;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.base.view.base_dialogs.ConfirmationDialog;
import com.elintminds.osdb.ui.dashboard.Interfaces.DiscussionOnClick;
import com.elintminds.osdb.ui.dashboard.adapters.DiscussionAdapter;
import com.elintminds.osdb.ui.dashboard.beans.DiscussionAdapterBean;
import com.elintminds.osdb.ui.dashboard.presenter.DiscussionPresenterClass;
import com.elintminds.osdb.ui.discussion_comments.view.DiscussionCommentsActivity;
import com.elintminds.osdb.ui.report.view.ReportActivity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DiscussionFragment extends BaseFragment implements DiscussionView, DiscussionOnClick, BaseDialogView.ConfirmationDialogListener {
    public static final String TAG = "DiscussionFragment";

    //    No data found layout
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;
    private SwipeRefreshLayout swipeRefreshLayout;

    private ArrayList<DiscussionAdapterBean.Threads> discussionList = new ArrayList<>();
    private DiscussionAdapter discussionAdapter;
    private ShimmerRecyclerView discussionRecyclerView;
    private DiscussionPresenterClass discussionPresenterClass;
    Bundle args;

    public static DiscussionFragment newInstance() {
        return new DiscussionFragment();
    }

    @Override
    protected void setUp(View view) {

        //        No data found Views
        txt_no_data_title = view.findViewById(R.id.txt_no_data_title);
        txt_no_data_disp = view.findViewById(R.id.txt_no_data_disp);
        no_data = view.findViewById(R.id.no_data);
        txt_no_data_title.setText(getString(R.string.no_data_found));
        txt_no_data_disp.setText(getString(R.string.please_try_again));
        no_data.setVisibility(View.GONE);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        discussionRecyclerView = view.findViewById(R.id.disccusion_recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        discussionRecyclerView.setLayoutManager(llm);
        discussionAdapter = new DiscussionAdapter(getContext(), discussionList, this);
        discussionRecyclerView.setAdapter(discussionAdapter);
        discussionRecyclerView.showShimmerAdapter();

        discussionPresenterClass = new DiscussionPresenterClass(getActivity(), this);
        discussionPresenterClass.getDiscussionData();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                no_data.setVisibility(View.GONE);
                discussionRecyclerView.setVisibility(View.VISIBLE);
                discussionRecyclerView.showShimmerAdapter();
                discussionPresenterClass.getDiscussionData();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dashboard_fragment_view, container, false);
    }

    @Override
    public void getSuccess(@NotNull DiscussionAdapterBean discussData) {

        if (discussData.getThreads().size() > 0) {
            discussionAdapter.setDataList(discussData.getThreads());
        } else {
            discussionRecyclerView.setVisibility(View.GONE);
            no_data.setVisibility(View.VISIBLE);
        }
        swipeRefreshLayout.setRefreshing(false);
        discussionRecyclerView.hideShimmerAdapter();
    }

    @Override
    public void getError(@NotNull String error, boolean isVisible) {
        if (isVisible) {
            discussionRecyclerView.setVisibility(View.GONE);
            no_data.setVisibility(View.VISIBLE);
        }
        discussionRecyclerView.hideShimmerAdapter();
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void discussionOnClick(String id,String name,String comment ,String time,String filepath,String commentNumber) {
        if (getActivity() != null && isAdded())
            startActivity(new Intent(getActivity(), DiscussionCommentsActivity.class)
                    .putExtra("isInnerComment", false)
                    .putExtra("id", id)
                    .putExtra("name", name)
                    .putExtra("comment", comment)
                    .putExtra("time", time)
                    .putExtra("filepath", filepath)
                    .putExtra("commentNumber", commentNumber)
            );
    }

    @Override
    public void discussionReportOnClick(int pos, String id) {
        if (getActivity() != null && isAdded()) {
            args = new Bundle();
            args.putString("DIALOG_TITLE", getString(R.string.report));
            args.putString("MESSAGE", getString(R.string.report_msg));
            args.putString("BUTTON_TEXT", getString(R.string.report));

            ConfirmationDialog confirmationDialog = ConfirmationDialog.newInstance(args);
            confirmationDialog.setListener(this);
            showDialog(confirmationDialog);

        }
    }

    @Override
    public void onConfirmOkClick(int dialogId) {
        startActivity(new Intent(getActivity(), ReportActivity.class));
    }
}
