package com.elintminds.osdb.ui.dashboard.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.dashboard.Interfaces.BornTodayOnClick;
import com.elintminds.osdb.ui.dashboard.adapters.BornTodayAdapter;
import com.elintminds.osdb.ui.dashboard.adapters.DoYouKnowAdapter;
import com.elintminds.osdb.ui.dashboard.adapters.SportsListAdapter;
import com.elintminds.osdb.ui.dashboard.beans.*;
import com.elintminds.osdb.ui.dashboard.model.HomeFragmentInteractor;
import com.elintminds.osdb.ui.dashboard.presenter.HomeFragmentPresenterClass;
import com.elintminds.osdb.ui.detailview.view.DetailActivity;
import com.elintminds.osdb.ui.do_you_know.view.DoYouKnowActivity;
import com.elintminds.osdb.ui.particular_sport_screen.view.SportsActivity;
import com.elintminds.osdb.ui.player_details_screen.view.PlayerDetailsActivity;
import com.elintminds.osdb.utils.Utils;
import io.supercharge.shimmerlayout.ShimmerLayout;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.*;

public class HomeFragment extends BaseFragment implements View.OnClickListener,
        DashboardView.SportsAdapterItemClickListener, HomeFragmentView, BornTodayOnClick {
    public static final String TAG = "HomeFragment";

    //    No data found layout
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;
    private CardView cv_on_this_day;
    private LinearLayout ll_poll_layout, ll_feature_athlete, poll_option_parent;
    private RelativeLayout rl_hide_layout_home;
    private Context context;
    private ShimmerRecyclerView sportsRecyclerView, rcv_do_you_know;
    private ShimmerRecyclerView bornTodayRecyclerView;
    private SportsListAdapter sportsListAdapter;
    private BornTodayAdapter bornTodayAdapter;
    private DoYouKnowAdapter doYouKnowAdapter;
    private ShimmerLayout shimmer_breaking_news;
    private ArrayList<SportsAdapterListBean> sportsList = new ArrayList<>();
    private ArrayList<HomeBean.DidYouKnow> didYouKnow = new ArrayList<>();
    private ArrayList<HomeBean.BornToday> bornTodayList = new ArrayList<>();
    private HomeFragmentPresenterClass<HomeFragment, com.elintminds.osdb.ui.dashboard.model.HomeFragmentInteractor> homeFragmentPresenterClass;
    private TextView view_1_msg_text, view_1_game_name, view_1_date, view_1_time_stamp, view_4_msg_text, view_6_msg_text;
    private ImageView view_1_image;
    private CardView cv_main_did_you_know;
    private RelativeLayout rl_breaking_news, rl_main_breaking_news;
    private LinearLayout ll_main_born_today;
    private SwipeRefreshLayout swipe_refresh;
    private HomeBean.BreakingNews breakingNewsFrag;
    private HomeBean.DidYouKnow doYouKnow;
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


        //        No data found Views
        txt_no_data_title = view.findViewById(R.id.txt_no_data_title);
        txt_no_data_disp = view.findViewById(R.id.txt_no_data_disp);
        no_data = view.findViewById(R.id.no_data);
        txt_no_data_title.setText(getString(R.string.no_data_found));
        txt_no_data_disp.setText(getString(R.string.please_try_again));
        no_data.setVisibility(View.GONE);

        context = getContext();
        Log.e("HomeSwipeData", "   setUpLayout");
//      sports list data
        sportsRecyclerView = view.findViewById(R.id.sportsList);
        sportsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        sportsListAdapter = new SportsListAdapter(context, sportsList, this);
        sportsRecyclerView.setAdapter(sportsListAdapter);

//       breaking news data
        rl_breaking_news = view.findViewById(R.id.rl_breaking_news);
        rl_main_breaking_news = view.findViewById(R.id.rl_main_breaking_news);
        shimmer_breaking_news = view.findViewById(R.id.shimmer_breaking_news);


//      born today data
        bornTodayRecyclerView = view.findViewById(R.id.born_today_recycler);
        ll_main_born_today = view.findViewById(R.id.ll_main_born_today);
        bornTodayRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        bornTodayAdapter = new BornTodayAdapter(context, bornTodayList, this);
        bornTodayRecyclerView.setAdapter(bornTodayAdapter);

//      did you know data
        rcv_do_you_know = view.findViewById(R.id.rcv_do_you_know);
        rcv_do_you_know.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        cv_main_did_you_know = view.findViewById(R.id.cv_main_did_you_know);

//      feature athlete
        ll_feature_athlete = view.findViewById(R.id.ll_feature_athlete);

//      on this day
        cv_on_this_day = view.findViewById(R.id.cv_on_this_day);
        view_6_msg_text = view.findViewById(R.id.view_6_msg_text);

//      feature player
        ll_poll_layout = view.findViewById(R.id.ll_poll_layout);
        view_4_msg_text = view.findViewById(R.id.view_4_msg_text);

        rl_hide_layout_home = view.findViewById(R.id.rl_hide_layout_home);
        view_1_msg_text = view.findViewById(R.id.view_1_msg_text);
        view_1_date = view.findViewById(R.id.view_1_date);
        view_1_time_stamp = view.findViewById(R.id.view_1_time_stamp);
        view_1_game_name = view.findViewById(R.id.view_1_game_name);
//      polls
        poll_option_parent = view.findViewById(R.id.poll_option_parent);

        view_1_image = view.findViewById(R.id.view_1_image);

        swipe_refresh = view.findViewById(R.id.swipe_refresh);
        homeFragmentPresenterClass = new HomeFragmentPresenterClass<>(getActivity(), this);
        setUpStartingData();

        rl_breaking_news.setOnClickListener(this);
        cv_main_did_you_know.setOnClickListener(this);


        swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.e("HomeSwipeData", "   Inside refresh layout");
                setUpStartingData();

            }
        });
    }

    private void setUpStartingData() {
        //              sports list data
        sportsRecyclerView.setVisibility(View.VISIBLE);
        sportsRecyclerView.showShimmerAdapter();

//              breaking news data
        rl_main_breaking_news.setVisibility(View.VISIBLE);
        rl_breaking_news.setVisibility(View.GONE);
        shimmer_breaking_news.setVisibility(View.VISIBLE);
        shimmer_breaking_news.startShimmerAnimation();

//              born today data
        ll_main_born_today.setVisibility(View.VISIBLE);
        bornTodayRecyclerView.showShimmerAdapter();

//              did you know data

        cv_main_did_you_know.setVisibility(View.VISIBLE);
        rcv_do_you_know.showShimmerAdapter();


        ll_feature_athlete.setVisibility(View.GONE);
        homeFragmentPresenterClass.getHomeData(getCurrentDate());
    }


    @Override
    public void onSportsIconClick(int position, String name) {
        Intent sportIntent = new Intent(context, SportsActivity.class);
        sportIntent.putExtra("SPORT_ID", position);
        sportIntent.putExtra("SPORT_NAME", name);
        sportIntent.putExtra("SPORT_LIST", sportsList);
        startActivity(sportIntent);
    }


    @Override
    public void getHomesData(HomeBean homesData) {
        if (homesData != null) {
            Log.e("HomeData", "Success  " + homesData.getSportsList().get(0).getDescription());

//        set sports data
            if (homesData.getSportsList() != null && homesData.getSportsList().size() > 0) {
                this.sportsList = homesData.getSportsList();
                sportsListAdapter.setDataList(this.sportsList);
                sportsRecyclerView.hideShimmerAdapter();
            } else {
                sportsRecyclerView.setVisibility(View.GONE);

            }

//        set home data
            if (homesData.getBreakingNews() != null && homesData.getBreakingNews().size() > 0) {
                breakingNewsFrag = homesData.getBreakingNews().get(0);
                if (breakingNewsFrag.getImageUrl() != null && !breakingNewsFrag.getImageUrl().equals("")) {
                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.placeholder(R.drawable.place);
                    Glide.with(Objects.requireNonNull(getActivity())).setDefaultRequestOptions(requestOptions)
                            .load(breakingNewsFrag.getImageUrl()).into(view_1_image);
                }
                if (breakingNewsFrag.getTitle() != null) {
                    Log.e("getBreakingNewWorking", "title    " + breakingNewsFrag.getTitle());
                    view_1_msg_text.setText(breakingNewsFrag.getTitle());
//                Utils.justify(view_1_msg_text);
                }

                shimmer_breaking_news.stopShimmerAnimation();
                shimmer_breaking_news.setVisibility(View.GONE);
                rl_breaking_news.setVisibility(View.VISIBLE);
            } else {
                rl_main_breaking_news.setVisibility(View.GONE);
            }

//        born today data set
            if (homesData.getBornToday() != null && homesData.getBornToday().size() > 0) {
                bornTodayList = homesData.getBornToday();
                bornTodayAdapter.setDataList(bornTodayList);
                bornTodayRecyclerView.hideShimmerAdapter();
            } else {
                ll_main_born_today.setVisibility(View.GONE);

            }

//        Did you know data set

            if (homesData.getDidYouKnow() != null && homesData.getDidYouKnow().size() > 0) {
                doYouKnowAdapter = new DoYouKnowAdapter(getActivity(), homesData.getDidYouKnow());
                rcv_do_you_know.setAdapter(doYouKnowAdapter);
                cv_main_did_you_know.setVisibility(View.VISIBLE);
                rcv_do_you_know.hideShimmerAdapter();
            } else {
                rcv_do_you_know.hideShimmerAdapter();
                cv_main_did_you_know.setVisibility(View.GONE);
            }


//            on this day data
            if (homesData.getOnThisDay() != null && homesData.getOnThisDay().size() > 0) {
                String contentOnThisDay = homesData.getOnThisDay().get(0).getContent();
                if (contentOnThisDay != null) {
                    view_6_msg_text.setText(Html.fromHtml(contentOnThisDay));
                    cv_on_this_day.setVisibility(View.VISIBLE);
                } else {
                    cv_on_this_day.setVisibility(View.GONE);
                }
            } else {
                cv_on_this_day.setVisibility(View.GONE);
            }

//            polls data
            if (homesData.getFeaturedPoll() != null && homesData.getFeaturedPoll().getPoll() != null) {
                view_4_msg_text.setText(homesData.getFeaturedPoll().getPoll().getText());
                ll_poll_layout.setVisibility(View.VISIBLE);

                if (homesData.getFeaturedPoll().getPoll().getOptions() != null && homesData.getFeaturedPoll().getPoll().getOptions().size() > 0) {
                    setPollsOptions(homesData.getFeaturedPoll().getPoll().getOptions(), homesData.getFeaturedPoll().getPoll().getId());
                }

            } else {
                ll_poll_layout.setVisibility(View.GONE);
            }

            rl_hide_layout_home.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.GONE);

        } else {
            rl_hide_layout_home.setVisibility(View.GONE);
            no_data.setVisibility(View.VISIBLE);
        }

        swipe_refresh.setRefreshing(false);
    }

    @Override
    public void AddVotePollsSuccess(String jsonObject) {
        try {
            JSONObject jsonObject1 = new JSONObject(jsonObject);
            setPollResult(jsonObject1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void setPollsOptions(final List<HomeBean.Option> options, final int pollID) {
        poll_option_parent.removeAllViews();
        String[] optionsCharArray = context.getResources().getStringArray(R.array.option_type);
        for (int i = 0; i < options.size(); i++) {
//            polls Options
            View pollOptionView = LayoutInflater.from(context).inflate(R.layout.poll_options_view, null);
            poll_option_parent.addView(pollOptionView);
            poll_option_parent.setId(i);
            TextView pollLabel = pollOptionView.findViewById(R.id.poll_label);
            TextView poll_name = pollOptionView.findViewById(R.id.poll_name);
            pollLabel.setText(optionsCharArray[i]);
            poll_name.setText(options.get(i).getText());
            pollLabel.setTextColor(context.getResources().getColor(R.color.color_2E384D));
        }

        poll_option_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dataList.get(i).setVisible(true);
                String pollId = String.valueOf(pollID);
                String optionId = String.valueOf(options.get(view.getId()).getId());

                homeFragmentPresenterClass.AddVote(getActivity(), pollId, optionId);

            }
        });
    }

    private void setPollResult(JSONObject jsonObject) {
        poll_option_parent.removeAllViews();
        int size = 0;
        int counter = 0;
        ArrayList<String> titleArray = new ArrayList<>();
        if (jsonObject.has("poll")) {
            if (jsonObject.has("options")) {
                try {
                    JSONArray optionArray = jsonObject.getJSONArray("options");
                    size = optionArray.length();
                    for (int i = 0; i < size; i++) {
                        JSONObject optionObj = optionArray.getJSONObject(i);
                        titleArray.add(optionObj.getString("text"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        if (jsonObject.has("result")) {
            try {
                JSONObject resultObj = jsonObject.getJSONObject("result");
                Iterator resultIterator = resultObj.keys();
                String[] optionsCharArray = context.getResources().getStringArray(R.array.option_type);
                while (resultIterator.hasNext()) {
                    String keyValue = (String) resultIterator.next();
                    String value = resultObj.getString(keyValue);

                    View pollOptionView = LayoutInflater.from(context).inflate(R.layout.poll_options_view, null);
                    poll_option_parent.addView(pollOptionView);
                    poll_option_parent.setId(counter);
                    TextView pollLabel = pollOptionView.findViewById(R.id.poll_label);
                    TextView poll_label_2 = pollOptionView.findViewById(R.id.poll_name);
                    TextView txt_polls_count = pollOptionView.findViewById(R.id.progress_percentage);
                    ProgressBar progressBar = pollOptionView.findViewById(R.id.progress_view);
                    if (titleArray.size() > 0) {
                        poll_label_2.setText(titleArray.get(counter));
                    } else {
                        poll_label_2.setText(String.valueOf(keyValue));
                    }
                    pollLabel.setText(optionsCharArray[counter]);
                    txt_polls_count.setText(value + " %");
                    double progress = Double.parseDouble(value);
                    progressBar.setProgress((int) progress);
                    counter++;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void getError(String error) {
        Log.e("HomeFragmentError===  ", error);
//        txt_no_data_title.setText(error);
        rl_hide_layout_home.setVisibility(View.GONE);
        no_data.setVisibility(View.VISIBLE);
        swipe_refresh.setRefreshing(false);
    }


    private String getCurrentDate() {
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date;

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
                break;
            }
            case R.id.cv_main_did_you_know: {
                Log.e("DidYouKnowClick", "Clicked");
                if (doYouKnow != null) {
                    Intent intent = new Intent(context, DoYouKnowActivity.class);
//                    intent.putExtra("imgUrl", (String) breakingNewsFrag.getImageUrl());
                    intent.putExtra("title", doYouKnow.getContent());
//                    intent.putExtra("bigContent", breakingNewsFrag.getLongContent());
//            intent.putExtra("teamName", teamName);
//            intent.putExtra("date", date);
//            intent.putExtra("timeStamp", timeStamp);
                    startActivity(intent);
                }
                break;
            }
        }
    }

    @Override
    public void bornTodayOnCLick(String age, String teamName, String divisionName, String playerId, String playerName, String profilePic, String dateOfBirth) {
        Intent intent = new Intent(context, PlayerDetailsActivity.class);
        intent.putExtra("AGE", age);
        intent.putExtra("PLAYER_NAME", playerName);
        intent.putExtra("TEAM_NAME", teamName);
        intent.putExtra("DIVISION_NAME", divisionName);
        intent.putExtra("PLAYER_ID", playerId);
        intent.putExtra("PROFILE_PIC", profilePic);
        intent.putExtra("dateOfBirth", dateOfBirth);
        startActivity(intent);
    }
}
////AGE,TEAM_NAME,DIVISION_NAME,PLAYER_ID,PLAYER_NAME