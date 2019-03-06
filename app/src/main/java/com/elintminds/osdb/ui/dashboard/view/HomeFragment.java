package com.elintminds.osdb.ui.dashboard.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.dashboard.adapters.BornTodayAdapter;
import com.elintminds.osdb.ui.dashboard.adapters.SportsListAdapter;
import com.elintminds.osdb.ui.dashboard.beans.*;
import com.elintminds.osdb.ui.dashboard.model.HomeFragmentInteractor;
import com.elintminds.osdb.ui.dashboard.presenter.HomeFragmentPresenterClass;
import com.elintminds.osdb.ui.detailview.view.DetailActivity;
import com.elintminds.osdb.ui.do_you_know.view.DoYouKnowActivity;
import com.elintminds.osdb.ui.particular_sport_screen.view.SportsActivity;
import io.supercharge.shimmerlayout.ShimmerLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends BaseFragment implements View.OnClickListener, DashboardView.SportsAdapterItemClickListener, HomeFragmentView {
    public static final String TAG = "HomeFragment";

    private Context context;
    private ShimmerRecyclerView sportsRecyclerView;
    private ShimmerRecyclerView bornTodayRecyclerView;
    private SportsListAdapter sportsListAdapter;
    private BornTodayAdapter bornTodayAdapter;
    private ShimmerLayout shimmer_breaking_news, shimmer_do_you_know;
    private ArrayList<SportsAdapterListBean> sportsList = new ArrayList<>();
    private ArrayList<BornTodayAdapterBean> bornTodayList = new ArrayList<>();
    private HomeFragmentPresenterClass<HomeFragment, com.elintminds.osdb.ui.dashboard.model.HomeFragmentInteractor> homeFragmentPresenterClass;
    private TextView view_1_msg_text, view_1_game_name, view_1_date, view_1_time_stamp, view_5_msg_text;
    private ImageView view_1_image, view_5_image;
    private RelativeLayout rl_breaking_news, rl_do_you_know;
    private NewsAdapterBean.BreakingNews breakingNewsFrag;
    private DoYouKnow doYouKnow;
    View view;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.home_fragment_view, container, false);
    }

    @Override
    protected void setUp(View view) {
        context = getContext();
        homeFragmentPresenterClass = new HomeFragmentPresenterClass<HomeFragment, HomeFragmentInteractor>(getActivity(), this);

        sportsRecyclerView = view.findViewById(R.id.sportsList);
        bornTodayRecyclerView = view.findViewById(R.id.born_today_recycler);

        view_1_msg_text = view.findViewById(R.id.view_1_msg_text);
        view_1_date = view.findViewById(R.id.view_1_date);
        view_1_time_stamp = view.findViewById(R.id.view_1_time_stamp);
        view_1_game_name = view.findViewById(R.id.view_1_game_name);
        view_5_msg_text = view.findViewById(R.id.view_5_msg_text);

        view_1_image = view.findViewById(R.id.view_1_image);
        view_5_image = view.findViewById(R.id.view_5_image);

        rl_breaking_news = view.findViewById(R.id.rl_breaking_news);
        rl_breaking_news.setVisibility(View.GONE);
        shimmer_breaking_news = view.findViewById(R.id.shimmer_breaking_news);
        shimmer_breaking_news.setVisibility(View.VISIBLE);
        shimmer_breaking_news.startShimmerAnimation();

        shimmer_do_you_know = view.findViewById(R.id.shimmer_do_you_know);
        rl_do_you_know = view.findViewById(R.id.rl_do_you_know);
        rl_do_you_know.setVisibility(View.GONE);
        shimmer_do_you_know.setVisibility(View.VISIBLE);
        shimmer_do_you_know.startShimmerAnimation();

        sportsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        sportsListAdapter = new SportsListAdapter(context, sportsList, this);
        sportsRecyclerView.setAdapter(sportsListAdapter);
        sportsRecyclerView.showShimmerAdapter();

        bornTodayRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        bornTodayAdapter = new BornTodayAdapter(context, bornTodayList);
        bornTodayRecyclerView.setAdapter(bornTodayAdapter);
        bornTodayRecyclerView.showShimmerAdapter();

        homeFragmentPresenterClass.getSportsData();
        homeFragmentPresenterClass.getBreakingNewsData();
        homeFragmentPresenterClass.getBornTodayData(getCurrentDate(), "10");
        homeFragmentPresenterClass.getDoYouKnow();

        rl_breaking_news.setOnClickListener(this);
        rl_do_you_know.setOnClickListener(this);
    }

    @Override
    public void onSportsIconClick(int position) {
        Intent sportIntent = new Intent(context, SportsActivity.class);
        sportIntent.putExtra("SPORT_ID", position);
        startActivity(sportIntent);
    }

    @Override
    public void getSportsData(ArrayList<SportsAdapterListBean> sportsList) {
        this.sportsList = sportsList;
        sportsListAdapter.setDataList(this.sportsList);
        sportsRecyclerView.hideShimmerAdapter();
    }

    @Override
    public void getHomesData(ArrayList<HomeAdapterListBean> homesData) {

    }

    @Override
    public void getBornTodayData(ArrayList<BornTodayAdapterBean> bornTodayData) {
        bornTodayList = bornTodayData;
        bornTodayAdapter.setDataList(bornTodayList);
        bornTodayRecyclerView.hideShimmerAdapter();

    }

    @Override
    public void getBreakingNews(ArrayList<NewsAdapterBean.BreakingNews> breakingNews) {
        Log.e("getBreakingNewWorking", "Breaking News Working");
        if (breakingNews.size() > 0) {
            breakingNewsFrag = breakingNews.get(0);
            if (breakingNewsFrag.getImageUrl() != null && !breakingNewsFrag.getImageUrl().equals(""))
                Glide.with(getActivity()).load(breakingNewsFrag.getImageUrl()).into(view_1_image);

            if (breakingNewsFrag.getTitle() != null) {
                view_1_msg_text.setText(breakingNewsFrag.getTitle());
            }
        }
        shimmer_breaking_news.stopShimmerAnimation();
        shimmer_breaking_news.setVisibility(View.GONE);
        rl_breaking_news.setVisibility(View.VISIBLE);

    }

    @Override
    public void getError(String error) {
        Log.e("HomeFragmentError===  ", error.toString());
    }

    @Override
    public void getDoYouKnow(ArrayList<DoYouKnow> doYouKnows) {
        if (doYouKnows.size() > 0) {
            doYouKnow = doYouKnows.get(0);

            if (doYouKnow.getContent() != null)
                view_5_msg_text.setText(Html.fromHtml(doYouKnow.getContent()).toString());
        }
        shimmer_do_you_know.stopShimmerAnimation();
        shimmer_do_you_know.setVisibility(View.GONE);
        rl_do_you_know.setVisibility(View.VISIBLE);
    }


    private String getCurrentDate() {
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date = null;

        Date currDate = Calendar.getInstance().getTime();
        date = spf.format(currDate);

        Log.e("Date", "" + date);

        return date;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Destroy", "Call");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_breaking_news: {
                if (breakingNewsFrag != null) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("imgUrl", (String) breakingNewsFrag.getImageUrl());
                    intent.putExtra("title", breakingNewsFrag.getTitle());
                    intent.putExtra("bigContent", breakingNewsFrag.getLongContent());
//            intent.putExtra("teamName", teamName);
//            intent.putExtra("date", date);
//            intent.putExtra("timeStamp", timeStamp);
                    startActivity(intent);
                }

            }
            case R.id.rl_do_you_know: {
                if (breakingNewsFrag != null) {
                    Intent intent = new Intent(context, DoYouKnowActivity.class);
//                    intent.putExtra("imgUrl", (String) breakingNewsFrag.getImageUrl());
                    intent.putExtra("title", doYouKnow.getContent());
//                    intent.putExtra("bigContent", breakingNewsFrag.getLongContent());
//            intent.putExtra("teamName", teamName);
//            intent.putExtra("date", date);
//            intent.putExtra("timeStamp", timeStamp);
                    startActivity(intent);
                }
            }
        }
    }
}
