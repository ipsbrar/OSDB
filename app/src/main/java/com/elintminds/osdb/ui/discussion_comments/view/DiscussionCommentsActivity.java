package com.elintminds.osdb.ui.discussion_comments.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.base.view.BaseDialogView;
import com.elintminds.osdb.ui.base.view.base_dialogs.ConfirmationDialog;
import com.elintminds.osdb.ui.discussion_comments.adapter.DiscussionCommentsAdapter;
import com.elintminds.osdb.ui.discussion_comments.adapter.InnerCommentsAdapter;
import com.elintminds.osdb.ui.discussion_comments.beans.DiscussionCommentsBean;
import com.elintminds.osdb.ui.report.view.ReportActivity;
import com.elintminds.osdb.ui.splash.presenter.DiscussionCommentsPresenterClass;
import com.elintminds.osdb.ui.splash.view.DiscussionCommentsView;
import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DiscussionCommentsActivity extends BaseActivity implements View.OnClickListener, DiscussionCommentsView, BaseDialogView.ConfirmationDialogListener {

    private ImageView backImg, user_Image;
    private ShimmerRecyclerView discussionCommentsRecyclerView;
    private TextView player_name, hours_txt, comment_txt, comments_number;


    private ArrayList<DiscussionCommentsBean.Comments> discussionList = new ArrayList<>();
    private DiscussionCommentsAdapter discussionAdapter;
    private LinearLayout reportLay;
    private DiscussionCommentsPresenterClass discussionCommentsPresenterClass;
    private Bundle args;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion_comment_detail);


        discussionCommentsRecyclerView = findViewById(R.id.comments_recycler_view);
        backImg = findViewById(R.id.backImg);
        user_Image = findViewById(R.id.user_Image);

        reportLay = findViewById(R.id.reportLay);

        player_name = findViewById(R.id.player_name);
        hours_txt = findViewById(R.id.hours_txt);
        comment_txt = findViewById(R.id.comment_txt);
        comments_number = findViewById(R.id.comments_number);


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        discussionCommentsRecyclerView.setLayoutManager(llm);
        discussionCommentsRecyclerView.showShimmerAdapter();

//        getComments();
        if (getIntent() != null) {
            String id = getIntent().getStringExtra("id");
            discussionCommentsPresenterClass = new DiscussionCommentsPresenterClass(this, this);
            discussionCommentsPresenterClass.getDiscussion(id);
            showProgressDialog();
        } else {
            showToast("No Id comes");
        }

        Log.e("DiscussionScreen===> ", getIntent().getBooleanExtra("isInnerComment", false) + "");
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
                args = new Bundle();
                args.putString("DIALOG_TITLE", getString(R.string.report));
                args.putString("MESSAGE", getString(R.string.report_msg));
                args.putString("BUTTON_TEXT", getString(R.string.report));

                ConfirmationDialog confirmationDialog = ConfirmationDialog.newInstance(args);
                confirmationDialog.setListener(this);
                showDialog(confirmationDialog);
                break;
        }
    }


    @Override
    public void onConfirmOkClick(int dialogId) {
        startActivity(new Intent(this, ReportActivity.class));
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
    public void getSuccess(DiscussionCommentsBean discussionCommentsBean) {
        player_name.setText(discussionCommentsBean.getCreated_by().getName() != null ? discussionCommentsBean.getCreated_by().getName() : "");
        comments_number.setText(discussionCommentsBean.getComments_count() != null ? discussionCommentsBean.getComments_count() : "");
        if (discussionCommentsBean.getDescription() != null) {
            String discription = Html.fromHtml(discussionCommentsBean.getDescription()).toString();
            comment_txt.setText(discription.trim());
        }
        if (discussionCommentsBean.getUpdated_at() != null) {
            hours_txt.setText(getFormatedDate(discussionCommentsBean.getUpdated_at()));
        }

        if (discussionCommentsBean.getComments().size() > 0) {
            discussionAdapter.setDataList(discussionCommentsBean.getComments());
        }
        hideProgressDialog();
        discussionCommentsRecyclerView.hideShimmerAdapter();

    }

    @NotNull
    @Override
    public void getError(String error) {
        hideProgressDialog();
        discussionCommentsRecyclerView.hideShimmerAdapter();

    }

    private String getFormatedDate(String rawDate) {
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
        DateFormat targetFormat = new SimpleDateFormat("h:mm a. MMM dd, yyyy");
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {

            Date date = originalFormat.parse(rawDate);
            String formattedDate = targetFormat.format(date);
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
