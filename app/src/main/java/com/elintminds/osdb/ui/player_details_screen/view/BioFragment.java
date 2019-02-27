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

public class BioFragment extends BaseFragment
{
    public static final String TAG = "BioFragment";

    private Context context;

    public static BioFragment getInstance()
    {
        return new BioFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.bio_fragment, container, false);
    }


    @Override
    protected void setUp(View view)
    {
        context = getContext();
    }
}