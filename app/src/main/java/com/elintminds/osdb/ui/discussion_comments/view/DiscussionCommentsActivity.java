package com.elintminds.osdb.ui.discussion_comments.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.discussion_comments.beans.DiscussionAdapterBean;
import com.elintminds.osdb.ui.discussion_comments.adapter.DiscussionCommentsAdapter;
import com.elintminds.osdb.ui.discussion_comments.adapter.InnerCommentsAdapter;
import com.elintminds.osdb.ui.report.view.ReportActivity;
import com.elintminds.osdb.ui.splash.presenter.DiscussionCommentsPresenterClass;
import com.elintminds.osdb.ui.splash.view.DiscussionCommentsView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DiscussionCommentsActivity extends BaseActivity implements View.OnClickListener, DiscussionCommentsView {

    private ImageView backImg;
    private ShimmerRecyclerView discussionCommentsRecyclerView;
    private ArrayList<DiscussionAdapterBean.Threads> discussionList = new ArrayList<>();
    private DiscussionCommentsAdapter discussionAdapter;
    private LinearLayout reportLay;
    private DiscussionCommentsPresenterClass discussionCommentsPresenterClass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion_comment_detail);


        discussionCommentsRecyclerView = findViewById(R.id.comments_recycler_view);
        backImg = findViewById(R.id.backImg);
        reportLay = findViewById(R.id.reportLay);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        discussionCommentsRecyclerView.setLayoutManager(llm);
        discussionCommentsRecyclerView.showShimmerAdapter();

//        getComments();
        discussionCommentsPresenterClass=new DiscussionCommentsPresenterClass(this,this);
        discussionCommentsPresenterClass.getDiscussion();

        Log.e("DiscussionScreen===> ",getIntent().getBooleanExtra("isInnerComment", false)+"");
        if (getIntent().getBooleanExtra("isInnerComment", false)) {
            InnerCommentsAdapter innerCommentAdapter = new InnerCommentsAdapter(this, discussionList);
            discussionCommentsRecyclerView.setAdapter(innerCommentAdapter);
        } else {
            discussionAdapter = new DiscussionCommentsAdapter(this, discussionList);
            discussionCommentsRecyclerView.setAdapter(discussionAdapter);
        }
        backImg.setOnClickListener(this);
        reportLay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.backImg:
                finish();
                break;

            case R.id.reportLay:
                startActivity(new Intent(this, ReportActivity.class));
                break;
        }
    }

//    private void getComments() {
//
//        DiscussionAdapterBean item1 = new DiscussionAdapterBean();
//
//        item1.setPlayerName("Dustin Waters");
//        item1.setComment("Nice");
//        discussionList.add(item1);
//        DiscussionAdapterBean item2 = new DiscussionAdapterBean();
//        item2.setPlayerName("Dale Terry");
//        item2.setComment("Best of Luck");
//        discussionList.add(item2);
//    }

    @NotNull
    @Override
    public void getSuccess(DiscussionAdapterBean discussionAdapterBean) {
        if (discussionAdapterBean.getThreads().size()>0){
            discussionAdapter.setDataList(discussionAdapterBean.getThreads());
        }
        discussionCommentsRecyclerView.hideShimmerAdapter();
    }

    @NotNull
    @Override
    public void getError(String error) {
        discussionCommentsRecyclerView.hideShimmerAdapter();

    }
}
