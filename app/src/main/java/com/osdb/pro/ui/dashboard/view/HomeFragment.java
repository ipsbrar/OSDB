package com.osdb.pro.ui.dashboard.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.google.gson.Gson;
import com.osdb.pro.R;
import com.osdb.pro.ui.base.view.BaseFragment;
import com.osdb.pro.ui.dashboard.Interfaces.BornTodayOnClick;
import com.osdb.pro.ui.dashboard.Interfaces.DoYouKnowOnClick;
import com.osdb.pro.ui.dashboard.adapters.BornTodayAdapter;
import com.osdb.pro.ui.dashboard.adapters.SportsListAdapter;
import com.osdb.pro.ui.dashboard.beans.*;
import com.osdb.pro.ui.dashboard.presenter.HomeFragmentPresenterClass;
import com.osdb.pro.ui.detailview.view.DetailActivity;
import com.osdb.pro.ui.do_you_know.view.DoYouKnowActivity;
import com.osdb.pro.ui.particular_sport_screen.view.SportsActivity;
import com.osdb.pro.ui.player_details_screen.view.PlayerDetailsActivity;
import com.osdb.pro.utils.Tag;
import com.osdb.pro.utils.TagView;
import com.osdb.pro.utils.Utils;
import io.supercharge.shimmerlayout.ShimmerLayout;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class HomeFragment extends BaseFragment implements View.OnClickListener,
        DashboardView.SportsAdapterItemClickListener, HomeFragmentView, BornTodayOnClick, DoYouKnowOnClick {
    public static final String TAG = "HomeFragment";

    //    No data found layout
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;

    private CardView cv_on_this_day;
    private LinearLayout ll_poll_layout, ll_feature_athlete, poll_option_parent;
    private RelativeLayout rl_hide_layout_home;
    private ShimmerRecyclerView sportsRecyclerView, rcv_do_you_know;
    private ShimmerRecyclerView bornTodayRecyclerView;
    private SportsListAdapter sportsListAdapter;
    private BornTodayAdapter bornTodayAdapter;
    private ShimmerLayout shimmer_breaking_news;
    private ArrayList<SportsAdapterListBean> sportsList = new ArrayList<>();
    private ArrayList<HomeBean.BornToday> bornTodayList = new ArrayList<>();
    private HomeFragmentPresenterClass<HomeFragment, com.osdb.pro.ui.dashboard.model.HomeFragmentInteractor> homeFragmentPresenterClass;
    private TextView view_1_msg_text, view_4_msg_text, view_6_msg_text, view_1_time_stamp, view_1_date, view_1_source;
    private ImageView view_1_image;
    private TagView view_1_game_name;
    //    private CardView cv_main_did_you_know;
    private RelativeLayout rl_breaking_news, rl_main_breaking_news;
    private LinearLayout ll_main_born_today;
    private SwipeRefreshLayout swipe_refresh;
    private HomeBean.BreakingNews breakingNewsFrag;
    private List<Tag> tagsList;

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

        Log.e("HomeSwipeData", "   setUpLayout");
//      sports list data
        sportsRecyclerView = view.findViewById(R.id.sportsList);
        sportsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        sportsListAdapter = new SportsListAdapter(getActivity(), sportsList, this);
        sportsRecyclerView.setAdapter(sportsListAdapter);

//       breaking news data
        rl_breaking_news = view.findViewById(R.id.rl_breaking_news);
        rl_main_breaking_news = view.findViewById(R.id.rl_main_breaking_news);
        shimmer_breaking_news = view.findViewById(R.id.shimmer_breaking_news);
        view_1_date = view.findViewById(R.id.view_1_date);
        view_1_time_stamp = view.findViewById(R.id.view_1_time_stamp);
        view_1_game_name = view.findViewById(R.id.view_1_game_name);
        view_1_source = view.findViewById(R.id.view_1_source);


//      born today data
        bornTodayRecyclerView = view.findViewById(R.id.born_today_recycler);
        ll_main_born_today = view.findViewById(R.id.ll_main_born_today);
        bornTodayRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        bornTodayAdapter = new BornTodayAdapter(getActivity(), bornTodayList, this);
        bornTodayRecyclerView.setAdapter(bornTodayAdapter);

//      did you know data
//        rcv_do_you_know = view.findViewById(R.id.rcv_do_you_know);
//        rcv_do_you_know.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
//        cv_main_did_you_know = view.findViewById(R.id.cv_main_did_you_know);

//      feature athlete
        ll_feature_athlete = view.findViewById(R.id.ll_feature_athlete);

//      on this day
        cv_on_this_day = view.findViewById(R.id.cv_on_this_day);
        view_6_msg_text = view.findViewById(R.id.view_6_msg_text);

//      feature player
        ll_poll_layout = view.findViewById(R.id.ll_poll_layout);
        view_4_msg_text = view.findViewById(R.id.view_4_msg_text);


//      polls
        poll_option_parent = view.findViewById(R.id.poll_option_parent);

        view_1_image = view.findViewById(R.id.view_1_image);
        rl_hide_layout_home = view.findViewById(R.id.rl_hide_layout_home);
        view_1_msg_text = view.findViewById(R.id.view_1_msg_text);

        swipe_refresh = view.findViewById(R.id.swipe_refresh);
        homeFragmentPresenterClass = new HomeFragmentPresenterClass<>(getActivity(), this);
        setUpStartingData();

        rl_breaking_news.setOnClickListener(this);
//        cv_main_did_you_know.setOnClickListener(this);


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
//        cv_main_did_you_know.setVisibility(View.GONE);
//        rcv_do_you_know.showShimmerAdapter();

//        feature poll
        ll_poll_layout.setVisibility(View.GONE);

//        feature athlete
        ll_feature_athlete.setVisibility(View.GONE);

        homeFragmentPresenterClass.getHomeData(getCurrentDate());
    }

    @Override
    public void getHomesData(HomeBean homesData) {
        if (homesData != null) {
//        set sports data
            setSportsData(homesData.getSportsList());

//        set breaking news data
            setBreakingNewsData(homesData.getBreakingNews());

//        born today data set
            setBornTodayData(homesData.getBornToday());

//        Did you know data set
//            setDidYouKnowData(homesData.getDidYouKnow());

//            on this day data
            setOnThisDay(homesData.getOnThisDay());


//            polls data
            setPollsData(homesData.getFeaturedPoll());

            rl_hide_layout_home.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.GONE);

        } else {
            rl_hide_layout_home.setVisibility(View.GONE);
            no_data.setVisibility(View.VISIBLE);
        }

        swipe_refresh.setRefreshing(false);
    }

    // set poll data 
    private void setPollsData(HomeBean.FeaturedPoll featuredPoll) {
        if (featuredPoll != null && featuredPoll.getPoll() != null) {
            view_4_msg_text.setText(featuredPoll.getPoll().getText());
            ll_poll_layout.setVisibility(View.VISIBLE);

            if (featuredPoll.getPoll().getOptions() != null && featuredPoll.getPoll().getOptions().size() > 0) {
                setPollsOptions(featuredPoll.getPoll().getOptions(), featuredPoll.getPoll().getId());
            }
        } else {
            ll_poll_layout.setVisibility(View.GONE);
        }
    }

    @Override
    public void AddVotePollsSuccess(String jsonObject) {
        try {
            JSONObject jsonObject1 = new JSONObject(jsonObject);
            Gson gson = new Gson();

            HomeBean.FeaturedPoll featuredPoll = gson.fromJson(jsonObject.toString(), HomeBean.FeaturedPoll.class);

            setPollResult(jsonObject1, featuredPoll.getPoll().getOptions());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void setPollsOptions(final List<HomeBean.Option> options, final int pollID) {
        poll_option_parent.removeAllViews();
        String[] optionsCharArray = getActivity().getResources().getStringArray(R.array.option_type);
        for (int i = 0; i < options.size(); i++) {
//            polls Options
            View pollOptionView = LayoutInflater.from(getActivity()).inflate(R.layout.poll_options_view, null);
            poll_option_parent.addView(pollOptionView);
            poll_option_parent.setId(i);
            TextView pollLabel = pollOptionView.findViewById(R.id.poll_label);
            TextView poll_name = pollOptionView.findViewById(R.id.poll_name);
            pollLabel.setText(optionsCharArray[i]);
            poll_name.setText(options.get(i).getText());
            pollLabel.setTextColor(getActivity().getResources().getColor(R.color.color_2E384D));
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

    private void setPollResult(JSONObject jsonObject, List<HomeBean.Option> options) {
        poll_option_parent.removeAllViews();
        int size = 0;
        int counter = 0;
        ArrayList<String> titleArray = new ArrayList<>();
//        if (jsonObject.has("poll")) {
//            if (jsonObject.has("options")) {
//                try {
//                    JSONArray optionArray = jsonObject.getJSONArray("options");
//                    size = optionArray.length();
//                    for (int i = 0; i < size; i++) {
//                        JSONObject optionObj = optionArray.getJSONObject(i);
//                        titleArray.add(optionObj.getString("text"));
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


        for (int i = 0; i < options.size(); i++) {

            titleArray.add(options.get(i).getText());
        }
        if (jsonObject.has("result")) {
            try {
                JSONObject resultObj = jsonObject.getJSONObject("result");
                Iterator resultIterator = resultObj.keys();
                String[] optionsCharArray = getActivity().getResources().getStringArray(R.array.option_type);
                while (resultIterator.hasNext()) {
                    String keyValue = (String) resultIterator.next();
                    String value = resultObj.getString(keyValue);

                    View pollOptionView = LayoutInflater.from(getActivity()).inflate(R.layout.poll_options_view, null);
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

    // set on this day data 
    private void setOnThisDay(ArrayList<HomeBean.OnThisDay> onThisDay) {
        if (onThisDay != null && onThisDay.size() > 0) {
            String contentOnThisDay = onThisDay.get(0).getContent();
            if (contentOnThisDay != null) {
                view_6_msg_text.setText(Html.fromHtml(contentOnThisDay));
                cv_on_this_day.setVisibility(View.VISIBLE);
            } else {
                cv_on_this_day.setVisibility(View.GONE);
            }
        } else {
            cv_on_this_day.setVisibility(View.GONE);
        }
    }

    // set did you data 
//    private void setDidYouKnowData(ArrayList<HomeBean.DidYouKnow> didYouKnow) {
//        if (didYouKnow != null && didYouKnow.size() > 0) {
//            DoYouKnowAdapter doYouKnowAdapter = new DoYouKnowAdapter(getActivity(), didYouKnow, this);
//            rcv_do_you_know.setAdapter(doYouKnowAdapter);
//            cv_main_did_you_know.setVisibility(View.VISIBLE);
//            rcv_do_you_know.hideShimmerAdapter();
//        } else {
//            rcv_do_you_know.hideShimmerAdapter();
//            cv_main_did_you_know.setVisibility(View.GONE);
//        }
//    }


    @Override
    public void doYouItemOnCLick(HomeBean.DidYouKnow doYouKnow) {
        if (doYouKnow != null) {

            Intent intent = new Intent(getActivity(), DoYouKnowActivity.class);
            if (doYouKnow.getAssets() != null && doYouKnow.getAssets().size() > 0) {
                intent.putExtra("imgUrl", doYouKnow.getAssets().get(0).getFileName());
            }
            intent.putExtra("title", doYouKnow.getContent());
//                    intent.putExtra("bigContent", breakingNewsFrag.getLongContent());
//            intent.putExtra("teamName", teamName);
//            intent.putExtra("date", date);
//            intent.putExtra("timeStamp", timeStamp);
            startActivity(intent);
        }
    }

    // set born today data
    private void setBornTodayData(ArrayList<HomeBean.BornToday> bornToday) {
        if (bornToday != null && bornToday.size() > 0) {
            bornTodayList = bornToday;
            bornTodayAdapter.setDataList(bornTodayList);
            bornTodayRecyclerView.hideShimmerAdapter();
        } else {
            ll_main_born_today.setVisibility(View.GONE);

        }
    }

    @Override
    public void bornTodayOnCLick(String age, String teamName, String divisionName, String playerId, String playerName, String profilePic, String dateOfBirth) {
        Intent intent = new Intent(getActivity(), PlayerDetailsActivity.class);
        intent.putExtra("AGE", age);
        intent.putExtra("PLAYER_NAME", playerName);
        intent.putExtra("TEAM_NAME", teamName);
        intent.putExtra("DIVISION_NAME", divisionName);
        intent.putExtra("PLAYER_ID", playerId);
        intent.putExtra("PROFILE_PIC", profilePic);
        intent.putExtra("dateOfBirth", dateOfBirth);
        startActivity(intent);
    }

    // set breaking news
    private void setBreakingNewsData(ArrayList<HomeBean.BreakingNews> breakingNews) {
        if (breakingNews != null && breakingNews.size() > 0) {
            breakingNewsFrag = breakingNews.get(0);
            List<Tag> tagsList = new ArrayList<>();
            if (breakingNewsFrag.getImageUrl() != null && !breakingNewsFrag.getImageUrl().equals("")) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.place);
                Glide.with(Objects.requireNonNull(getActivity())).setDefaultRequestOptions(requestOptions)
                        .load(breakingNewsFrag.getImageUrl()).into(view_1_image);
            }

            view_1_msg_text.setText(breakingNewsFrag.getTitle() != null ? breakingNewsFrag.getTitle() : "");
            view_1_source.setText(breakingNewsFrag.getSource() != null ? "By: " + breakingNewsFrag.getSource() : "");


            if (breakingNewsFrag.getSlug() != null) {
                Tag tag = new Tag(breakingNewsFrag.getSlug());
                tagsList.add(tag);
            }
            String tags = breakingNewsFrag.getTags();
            if (tags != null) {
                if (tags.contains(",")) {
                    List<String> items = Arrays.asList(tags.split("\\s*,\\s*"));
                    for (int j = 0; j < items.size(); j++) {
                        if (!items.get(j).equalsIgnoreCase("")) {
                            Tag tag = new Tag(items.get(j));
                            tagsList.add(tag);
                        }
                    }
                } else {
                    if (!TextUtils.isEmpty(tags)) {
                        Tag tag = new Tag(breakingNewsFrag.getTags());
                        tagsList.add(tag);
                    }

                }
            }
            view_1_game_name.addTags(tagsList);
            if (breakingNewsFrag.getPublishedAt() != null && !TextUtils.isEmpty(breakingNewsFrag.getPublishedAt())) {
                view_1_date.setText(Utils.getFormatedDate(breakingNewsFrag.getPublishedAt()
                        , "yyyy-MM-dd hh:mm:ss"
                        , "MMM. dd, yyyy"));
                long timeInLong = Utils.getLongTime(breakingNewsFrag.getPublishedAt() != null ?
                        breakingNewsFrag.getPublishedAt() :
                        "2019-02-21 03:24:54", "yyyy-MM-dd hh:mm:ss");
                view_1_time_stamp.setText(Utils.getFullTimeAgo(timeInLong));
            }
            shimmer_breaking_news.stopShimmerAnimation();
            shimmer_breaking_news.setVisibility(View.GONE);
            rl_breaking_news.setVisibility(View.VISIBLE);
        } else {
            rl_main_breaking_news.setVisibility(View.GONE);
        }
    }

    // set top sports list
    private void setSportsData(ArrayList<SportsAdapterListBean> sportsList) {
        if (sportsList != null && sportsList.size() > 0) {
            this.sportsList = sportsList;
            sportsListAdapter.setDataList(this.sportsList);
            sportsRecyclerView.hideShimmerAdapter();
        } else {
            sportsRecyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSportsIconClick(int position, String name) {
        Intent sportIntent = new Intent(getActivity(), SportsActivity.class);
        sportIntent.putExtra("SPORT_ID", position);
        sportIntent.putExtra("SPORT_NAME", name);
        sportIntent.putExtra("SPORT_LIST", sportsList);
        startActivity(sportIntent);
    }

    @Override
    public void getError(String error) {
        Log.e("HomeFragmentError===  ", error);
//        txt_no_data_title.setText(error);
        rl_hide_layout_home.setVisibility(View.GONE);
        no_data.setVisibility(View.VISIBLE);
        swipe_refresh.setRefreshing(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_breaking_news: {
                if (breakingNewsFrag != null) {
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra("imgUrl", (String) breakingNewsFrag.getImageUrl());
                    intent.putExtra("title", breakingNewsFrag.getTitle());
                    intent.putExtra("bigContent", breakingNewsFrag.getLongContent());
                    intent.putExtra("teamName", (Serializable) tagsList);
                    intent.putExtra("source", view_1_source.getText().toString().trim());
                    intent.putExtra("date", view_1_date.getText().toString().trim());
                    intent.putExtra("timeStamp", view_1_time_stamp.getText().toString().trim());
                    startActivity(intent);
                }
                break;
            }
        }
    }

    private String getCurrentDate() {
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date;

        Date currDate = Calendar.getInstance().getTime();
        date = spf.format(currDate);

        Log.e("Date", "" + date);

        return date;
    }

}