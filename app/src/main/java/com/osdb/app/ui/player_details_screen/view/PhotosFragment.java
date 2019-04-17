package com.osdb.app.ui.player_details_screen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.osdb.app.R;
import com.osdb.app.ui.base.view.BaseFragment;
import com.osdb.app.ui.player_details_screen.adapters.PhotosAdapter;
import com.osdb.app.utils.CardPaddingItemDecoration;

import java.util.ArrayList;

public class PhotosFragment extends BaseFragment implements PlayerDetailsView.VideoPhotoAdapterListener {
    public static final String TAG = "PhotosFragment";
    private NestedScrollView nscrollImage;

    //no  data found
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;

    private Context context;
    private ShimmerRecyclerView photosRecyclerView;
    private ArrayList<String> photosList = new ArrayList<>();
    private PhotosAdapter adapter;

    public static PhotosFragment getInstance(ArrayList<String> arrayList) {
        PhotosFragment photosFragment = new PhotosFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("imageList", arrayList);
        photosFragment.setArguments(bundle);
        return photosFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.photo_player_details_fragment, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            photosList = (ArrayList<String>) bundle.getSerializable("imageList");
        }
        return view;
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

        nscrollImage = view.findViewById(R.id.nscrollImage);
        photosRecyclerView = view.findViewById(R.id.rcv_photo_player_details);

        if (photosList.size() > 0) {
            nscrollImage.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.GONE);
            setupRecyclerView();
        } else {
            nscrollImage.setVisibility(View.GONE);
            no_data.setVisibility(View.VISIBLE);
        }

    }


    private void setupRecyclerView() {
        CardPaddingItemDecoration itemDecoration = new CardPaddingItemDecoration(context, 10f, 10f, 7f, 7f);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 2);
        adapter = new PhotosAdapter(context, photosList, this);

        photosRecyclerView.addItemDecoration(itemDecoration);
        photosRecyclerView.setLayoutManager(layoutManager);
        photosRecyclerView.setNestedScrollingEnabled(false);
        photosRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(String path) {

    }
}
