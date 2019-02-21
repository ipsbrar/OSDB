package com.elintminds.osdb.ui.dashboard.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.dashboard.adapters.NewsListAdapter;
import com.elintminds.osdb.ui.dashboard.beans.NewsAdapterBean;
import com.elintminds.osdb.ui.detailview.view.DetailActivity;
import com.elintminds.osdb.utils.CardPaddingItemDecoration;

import java.util.ArrayList;

public class NewsFragment extends BaseFragment implements DashboardView.NewsItemsClickListener, View.OnClickListener {
    public static final String TAG = "NewsFragment";

    private Context context;
    private ShimmerRecyclerView newsRecyclerView;
    private ArrayList<NewsAdapterBean> newsList = new ArrayList<>();
    private NewsListAdapter adapter;
    private CardView topNews;

    public static NewsFragment getInstance() {
        return new NewsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_fragment_view, container, false);
    }

    @Override
    protected void setUp(View view) {
        context = getContext();
        newsRecyclerView = view.findViewById(R.id.news_recycler_view);
        topNews = view.findViewById(R.id.top_news);
        topNews.setOnClickListener(this);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        CardPaddingItemDecoration itemDecoration = new CardPaddingItemDecoration(context, 10f, 10f, 7f, 7f);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 2);
        adapter = new NewsListAdapter(context, newsList, this);

        newsRecyclerView.addItemDecoration(itemDecoration);
        newsRecyclerView.setLayoutManager(layoutManager);
        newsRecyclerView.setNestedScrollingEnabled(false);
        newsRecyclerView.setAdapter(adapter);
        newsRecyclerView.showShimmerAdapter();

        newsRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadNewsData();
            }
        }, 3000);

    }

    private void loadNewsData() {
        String[] newsArray = getResources().getStringArray(R.array.sampl_news);
        for (String nws : newsArray) {
            NewsAdapterBean item = new NewsAdapterBean();
            item.setTitle(nws);
            newsList.add(item);
        }

        Log.e("DATA", "" + newsList.size());
        adapter.setDataList(newsList);
        newsRecyclerView.hideShimmerAdapter();
    }

    @Override
    public void onNewsClick(int position) {
        Log.e("ON NEWS CLICK", "" + position);
        startActivity(new Intent(context, DetailActivity.class));
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.top_news: {
                onNewsClick(0);
                break;
            }

        }
    }
}
