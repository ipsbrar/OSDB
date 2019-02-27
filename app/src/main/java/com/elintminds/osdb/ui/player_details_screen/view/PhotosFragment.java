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
import com.elintminds.osdb.ui.player_details_screen.adapters.PhotosAdapter;
import com.elintminds.osdb.ui.player_details_screen.beans.PhotosBean;
import com.elintminds.osdb.utils.CardPaddingItemDecoration;

import java.util.ArrayList;

public class PhotosFragment extends BaseFragment implements PlayerDetailsView.VideoPhotoAdapterListener
{
    public static final String TAG = "PhotosFragment";

    private Context context;
    private ShimmerRecyclerView photosRecyclerView;
    private ArrayList<PhotosBean> photosList = new ArrayList<>();
    private PhotosAdapter adapter;

    public static PhotosFragment getInstance()
    {
        return new PhotosFragment();
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
        photosRecyclerView = view.findViewById(R.id.rcv_photo_player_details);

        setupRecyclerView();
    }


    private void setupRecyclerView()
    {
        CardPaddingItemDecoration itemDecoration = new CardPaddingItemDecoration(context, 10f, 10f, 7f,7f);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 2);
        adapter = new PhotosAdapter(context, photosList, this);

        photosRecyclerView.addItemDecoration(itemDecoration);
        photosRecyclerView.setLayoutManager(layoutManager);
        photosRecyclerView.setNestedScrollingEnabled(false);
        photosRecyclerView.setAdapter(adapter);
        photosRecyclerView.showShimmerAdapter();

        photosRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadPhotoData();
            }
        }, 3000);

    }

    private void loadPhotoData()
    {
        photosList.clear();
        String[] newsArray = context.getResources().getStringArray(R.array.sampl_news);
        for (String nws : newsArray) {
            PhotosBean item = new PhotosBean();
            photosList.add(item);
        }

        Log.e("DATA", "" + photosList.size());
        adapter.setDataList(photosList);
        photosRecyclerView.hideShimmerAdapter();
    }

    @Override
    public void onItemClick(int position)
    {

    }
}
