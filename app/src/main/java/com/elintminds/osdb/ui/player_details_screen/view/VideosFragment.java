package com.elintminds.osdb.ui.player_details_screen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.player_details_screen.adapters.VideosAdapter;
import com.elintminds.osdb.ui.player_details_screen.beans.VideosBean;
import com.elintminds.osdb.utils.CardPaddingItemDecoration;

import java.util.ArrayList;

public class VideosFragment extends BaseFragment implements PlayerDetailsView.VideoPhotoAdapterListener
{
    public static final String TAG = "VideosFragment";

    private Context context;
    private ShimmerRecyclerView videosRecyclerView;
    private ArrayList<VideosBean> videosList = new ArrayList<>();
    private VideosAdapter adapter;
    private ShimmerRecyclerView videosRecyclerView1;

    public static VideosFragment getInstance()
    {
        return new VideosFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.photo_player_details_fragment, container, false);
    }


    @Override
    protected void setUp(View view)
    {
        context = getContext();
        videosRecyclerView = view.findViewById(R.id.rcv_photo_player_details);

        setupRecyclerView();
    }

    private void setupRecyclerView()
    {
        CardPaddingItemDecoration itemDecoration = new CardPaddingItemDecoration(context, 10f, 10f, 7f,7f);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 2);
        adapter = new VideosAdapter(context, videosList, this);

        videosRecyclerView.addItemDecoration(itemDecoration);
        videosRecyclerView.setLayoutManager(layoutManager);
        videosRecyclerView.setNestedScrollingEnabled(false);
        videosRecyclerView.setAdapter(adapter);
        videosRecyclerView.showShimmerAdapter();

        videosRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadPhotoData();
            }
        }, 3000);

    }

    private void loadPhotoData()
    {
        videosList.clear();
        String[] newsArray = context.getResources().getStringArray(R.array.sampl_news);
        for (String nws : newsArray) {
            VideosBean item = new VideosBean();
            videosList.add(item);
        }

        Log.e("DATA", "" + videosList.size());
        adapter.setDataList(videosList);
        videosRecyclerView.hideShimmerAdapter();
    }

    @Override
    public void onItemClick(int position)
    {

    }
}
