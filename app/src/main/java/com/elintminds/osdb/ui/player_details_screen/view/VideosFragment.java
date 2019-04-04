package com.elintminds.osdb.ui.player_details_screen.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.player_details_screen.adapters.VideosAdapter;
import com.elintminds.osdb.ui.player_details_screen.beans.VideosBean;
import com.elintminds.osdb.utils.CardPaddingItemDecoration;

import java.util.ArrayList;

public class VideosFragment extends BaseFragment implements PlayerDetailsView.VideoPhotoAdapterListener {
    public static final String TAG = "VideosFragment";

    //no  data found
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;

    private NestedScrollView nscrollVideo;
    private Context context;
    private ShimmerRecyclerView videosRecyclerView;
    private ArrayList<VideosBean> videosList = new ArrayList<>();
    private VideosAdapter adapter;
    private String[] sampleTitles = {"Kris Bryant Placed on Disabled List...", "Arkansas Beats Heimlich, Oregon State in CWS..."
            , "Kris Bryant Placed on Disabled List...", "Arkansas Beats Heimlich, Oregon State in CWS..."
            , "Kris Bryant Placed on Disabled List...", "Arkansas Beats Heimlich, Oregon State in CWS..."};

    public static VideosFragment getInstance(ArrayList<VideosBean> videosBeanArrayList) {
        VideosFragment videosFragment = new VideosFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("videoList", videosBeanArrayList);
        videosFragment.setArguments(bundle);
        return videosFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.videos_fragment_view, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            videosList = (ArrayList<VideosBean>) bundle.getSerializable("videoList");
        }
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        for (String nws : sampleTitles) {
//            VideosBean item = new VideosBean();
//            item.setVideoTitle(nws);
//            videosList.add(item);
//        }
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


        nscrollVideo = view.findViewById(R.id.nscrollVideo);
        videosRecyclerView = view.findViewById(R.id.video_recyclerview);
        if (videosList.size() > 0) {
            nscrollVideo.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.GONE);
            setupRecyclerView();
        } else {
            nscrollVideo.setVisibility(View.GONE);
            no_data.setVisibility(View.VISIBLE);
        }
    }

    private void setupRecyclerView() {
        CardPaddingItemDecoration itemDecoration = new CardPaddingItemDecoration(context, 10f, 10f, 6f, 6f);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 2);
        adapter = new VideosAdapter(context, videosList, this);

        videosRecyclerView.addItemDecoration(itemDecoration);
        videosRecyclerView.setLayoutManager(layoutManager);
        videosRecyclerView.setNestedScrollingEnabled(false);
        videosRecyclerView.setAdapter(adapter);

    }


    @Override
    public void onItemClick(String path) {
        Intent intent = new Intent(getActivity(), VideoPlayActivity.class);
        intent.putExtra("PATH", path);
        startActivity(intent);
    }
}
