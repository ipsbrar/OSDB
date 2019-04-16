package com.osdb.pro.ui.player_details_screen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.osdb.pro.R;
import com.osdb.pro.ui.base.view.BaseFragment;
import com.osdb.pro.ui.player_details_screen.adapters.CareerAdapter;

import java.util.ArrayList;

public class CareerFragment extends BaseFragment {
    public static final String TAG = "CareerFragment";
    //no  data found
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;

    private SwipeRefreshLayout swipe_refresh;
    private Context context;
    private RecyclerView careerRV;
    private CareerAdapter adapter;
    private ArrayList<String> dataList = new ArrayList<>();

    private String[] sampleAchievement = {"Aaron Rodgers is the NFL's all-time regular season career passer rating leader and is one of two quarterbacks to have a regular season career passer rating of over 100."
            , "Rodgers is fifth all-time in postseason career passer rating, has the best touchdown-to-interception ratio in NFL history at 4.23, holds the league's lowest career interception percentage at 1.5 percent[6] and the highest single-season passer rating record of 122.5."
            , "Due to the fact that Rodgers is the NFL's all-time regular season career passer rating leader, and his overall high level of play"
            , "Jaire Alexander"
            , "Rodgers is considered by some sportscasters and players to be one of the greatest quarterbacks of all time"
    };

    public static CareerFragment getInstance(ArrayList<String> stringArrayList) {
        CareerFragment careerFragment = new CareerFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("careerHeights", stringArrayList);
        careerFragment.setArguments(bundle);
        return careerFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.single_recycler_view_2, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            dataList = (ArrayList<String>) bundle.getSerializable("careerHeights");
            Log.e("CareerHeights", "   " + dataList.size());
        }
        return view;
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

        careerRV = view.findViewById(R.id.recycler_view);
        swipe_refresh = view.findViewById(R.id.swipe_refresh);
        if (getActivity() instanceof PlayerDetailsActivity) {
            swipe_refresh.setRefreshing(false);
            swipe_refresh.setEnabled(false);
        }
        if (dataList.size() > 0) {
            careerRV.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.GONE);
            setupRecyclerView();
        } else {
            careerRV.setVisibility(View.GONE);
            no_data.setVisibility(View.VISIBLE);
        }

        swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipe_refresh.setRefreshing(false);
            }
        });
    }

    private void setupRecyclerView() {
        adapter = new CareerAdapter(context, dataList);
        careerRV.setAdapter(adapter);
    }
}
