package com.osdb.android.ui.dashboard.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.osdb.android.R;
import com.osdb.android.ui.base.view.BaseFragment;
import com.osdb.android.ui.dashboard.adapters.NewsListAdapter;
import com.osdb.android.ui.dashboard.beans.NewsAdapterBean;
import com.osdb.android.ui.dashboard.presenter.NewsFragmentPresenterClass;
import com.osdb.android.ui.detailview.view.DetailActivity;
import com.osdb.android.ui.player_details_screen.view.PlayerDetailsActivity;
import com.osdb.android.utils.CardPaddingItemDecoration;
import com.osdb.android.utils.Utils;
import io.supercharge.shimmerlayout.ShimmerLayout;

import java.util.ArrayList;

public class NewsFragment extends BaseFragment implements DashboardView.NewsItemsClickListener, View.OnClickListener, NewsFragmentView {
    public static final String TAG = "NewsFragment";

    private Context context;
    private ShimmerRecyclerView newsRecyclerView;
    private ArrayList<NewsAdapterBean.Datum> newsList = new ArrayList<>();
    private NewsListAdapter adapter;
    private CardView topNews;
    ShimmerLayout shimmer_break_latest;
    private NewsFragmentPresenterClass newsFragmentPresenterClass;
    private ImageView news_frag_image;
    private TextView news_title, news_frag_game_name, txt_date_breaking_news, txt_time_stamp_breaking_news, load_more_news;
    String imgUrl, title, bigContent, teamName, date, timeStamp;

    //    No data found layout
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;
    private RelativeLayout rl_hide_layout;
    private SwipeRefreshLayout swipeRefreshLayout;
    private int offsetData = 10;
    private int totalNewsCount = 0;

    public static NewsFragment getInstance() {
        return new NewsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_fragment_view, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    protected void setUp(View view) {
        context = getContext();

        //        No data found Views
        txt_no_data_title = view.findViewById(R.id.txt_no_data_title);
        txt_no_data_disp = view.findViewById(R.id.txt_no_data_disp);
        no_data = view.findViewById(R.id.no_data);
        txt_no_data_title.setText(getString(R.string.no_data_found));
        txt_no_data_disp.setText(getString(R.string.please_try_again));
        no_data.setVisibility(View.GONE);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        if (getActivity() instanceof PlayerDetailsActivity) {
            swipeRefreshLayout.setRefreshing(false);
            swipeRefreshLayout.setEnabled(false);
        }
        newsRecyclerView = view.findViewById(R.id.news_recycler_view);
        newsFragmentPresenterClass = new NewsFragmentPresenterClass(getActivity(), this);
        rl_hide_layout = view.findViewById(R.id.rl_hide_layout);
        shimmer_break_latest = view.findViewById(R.id.shimmer_break_latest);
        topNews = view.findViewById(R.id.top_news);
        topNews.setVisibility(View.GONE);
        shimmer_break_latest.startShimmerAnimation();
        shimmer_break_latest.setVisibility(View.VISIBLE);

        news_frag_image = view.findViewById(R.id.news_frag_image);
        news_title = view.findViewById(R.id.news_title);
        news_frag_game_name = view.findViewById(R.id.news_frag_game_name);
        txt_date_breaking_news = view.findViewById(R.id.txt_date_breaking_news);
        txt_time_stamp_breaking_news = view.findViewById(R.id.txt_time_stamp_breaking_news);
        load_more_news = view.findViewById(R.id.load_more_news);

        topNews.setOnClickListener(this);
        load_more_news.setOnClickListener(this);
        setupRecyclerView();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.e("HomeSwipeData", "   Inside refresh layout");
                rl_hide_layout.setVisibility(View.VISIBLE);
                shimmer_break_latest.setVisibility(View.VISIBLE);
                no_data.setVisibility(View.GONE);
                topNews.setVisibility(View.GONE);
                shimmer_break_latest.startShimmerAnimation();
                newsRecyclerView.showShimmerAdapter();
                offsetData = 10;
                newsList.clear();
                newsFragmentPresenterClass.getNewsData(offsetData);

            }
        });
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
        newsFragmentPresenterClass.getNewsData(offsetData);


    }


    @Override
    public void onNewsClick(int position) {
        Log.e("ON NEWS CLICK", "" + position);
        if (newsList.size() > 0) {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("imgUrl", newsList.get(position).getAsset() != null ? newsList.get(position).getAsset().getFileName() : null);
            intent.putExtra("title", newsList.get(position).getTitle());
            intent.putExtra("bigContent", newsList.get(position).getLongContent());
            intent.putExtra("teamName", newsList.get(position).getSlug());
            intent.putExtra("date", Utils.getFormatedDate(newsList.get(position).getPublishedAt()
                    , "yyyy-MM-dd hh:mm:ss"
                    , "MMM. dd, yyyy"));
            intent.putExtra("timeStamp", timeStamp);
            startActivity(intent);
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.top_news: {
                if (newsList.size() > 0) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("imgUrl", imgUrl);
                    intent.putExtra("title", title);
                    intent.putExtra("bigContent", bigContent);
                    intent.putExtra("teamName", teamName);
                    intent.putExtra("date", date);
                    intent.putExtra("timeStamp", timeStamp);
                    startActivity(intent);
                }
                break;
            }
            case R.id.load_more_news: {
                if (offsetData < totalNewsCount) {
                    showProgressDialog();
                    offsetData = offsetData + 10;
                    newsFragmentPresenterClass.getNewsData(offsetData);
                }
                break;
            }

        }
    }


    @Override
    public void getNewsData(NewsAdapterBean newsList) {
        hideProgressDialog();
        Log.e("DATA", "" + newsList.getData().size());
        if (newsList != null) {
            totalNewsCount = newsList.getTotalCount();
            if ((offsetData + 10) >= totalNewsCount) {
                load_more_news.setVisibility(View.GONE);
            } else {
                load_more_news.setVisibility(View.VISIBLE);
            }
            if (offsetData == 10) {
//            set breaking news data
                setBreakingNewsData(newsList.getBreakingNews());
            }
//            set normal new data
            if (newsList.getData().size() > 0) {
                this.newsList.addAll(newsList.getData());
                adapter.setDataList(this.newsList);
            }
        } else {
            rl_hide_layout.setVisibility(View.GONE);
            no_data.setVisibility(View.VISIBLE);
        }
        swipeRefreshLayout.setRefreshing(false);
        newsRecyclerView.hideShimmerAdapter();
        shimmer_break_latest.stopShimmerAnimation();
        shimmer_break_latest.setVisibility(View.GONE);
    }

    private void setBreakingNewsData(ArrayList<NewsAdapterBean.BreakingNews> breakingNews) {
        if (breakingNews.size() > 0) {
            topNews.setVisibility(View.VISIBLE);
            if (breakingNews.get(0).getImageUrl() != null && !breakingNews.get(0).getImageUrl().equals("")) {
                imgUrl = (String) breakingNews.get(0).getImageUrl();
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.place);
                Glide.with(getActivity()).setDefaultRequestOptions(requestOptions)
                        .load(imgUrl).into(news_frag_image);
            }
            if (breakingNews.get(0).getTitle() != null) {
                news_title.setText(breakingNews.get(0).getTitle());
                Utils.justify(news_title);
            }

            if (breakingNews.get(0).getPublishedAt() != null && !TextUtils.isEmpty(breakingNews.get(0).getPublishedAt()))
                date = breakingNews.get(0).getPublishedAt();
            txt_date_breaking_news.setText(Utils.getFormatedDate(breakingNews.get(0).getPublishedAt()
                    , "yyyy-MM-dd hh:mm:ss"
                    , "MMM. dd, yyyy"));

            long timeInLong = Utils.getLongTime(breakingNews.get(0).getPublishedAt() != null ?
                    breakingNews.get(0).getPublishedAt() :
                    "2019-02-21 03:24:54", "yyyy-MM-dd hh:mm:ss");
            timeStamp = Utils.getFullTimeAgo(timeInLong);
            txt_time_stamp_breaking_news.setText(timeStamp);

            imgUrl = (String) breakingNews.get(0).getImageUrl();
            title = breakingNews.get(0).getTitle();
            bigContent = breakingNews.get(0).getLongContent();
            teamName = breakingNews.get(0).getSlug();
            topNews.setVisibility(View.VISIBLE);
        } else {
            topNews.setVisibility(View.GONE);
        }

    }


    @Override
    public void getError(String error) {
        Toast.makeText(context, "error" + error, Toast.LENGTH_SHORT).show();
        Log.e("ErrorIS ", error);
        rl_hide_layout.setVisibility(View.GONE);
        no_data.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setRefreshing(false);
        newsRecyclerView.hideShimmerAdapter();
        shimmer_break_latest.stopShimmerAnimation();
    }


}
