package com.elintminds.osdb.ui.profile.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.dashboard.beans.EventsAdapterBean;
import com.elintminds.osdb.ui.dashboard.beans.NewsAdapterBean;
import com.elintminds.osdb.ui.profile.adapter.NotificationAdapter;

import java.util.ArrayList;

public class NotificationActivity extends BaseActivity {

    private ImageView backImg;
    private RecyclerView recyclerView;
    private NotificationAdapter notificationAdapter;
    private ArrayList<NewsAdapterBean> notificationsList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        backImg = findViewById(R.id.back_img);
        recyclerView = findViewById(R.id.notification_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadNotificationData();

        notificationAdapter= new NotificationAdapter(this,notificationsList);
        recyclerView.setAdapter(notificationAdapter);


        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


    private void loadNotificationData() {

        String[] newsArray = getResources().getStringArray(R.array.sampl_news);
        for (String nws : newsArray) {
            NewsAdapterBean item = new NewsAdapterBean();
            item.setTitle(nws);
            notificationsList.add(item);
        }
    }
}
