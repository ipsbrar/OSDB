package com.elintminds.osdb.ui.player_details_screen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;

public class PhotosFragment extends BaseFragment
{
    public static final String TAG = "PhotosFragment";

    private Context context;

    public static PhotosFragment getInstance()
    {
        return new PhotosFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.single_recycler_view, container, false);
    }


    @Override
    protected void setUp(View view)
    {
        context = getContext();
    }
}
