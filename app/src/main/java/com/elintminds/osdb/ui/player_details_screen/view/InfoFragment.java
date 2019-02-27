package com.elintminds.osdb.ui.player_details_screen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;

public class InfoFragment extends BaseFragment
{
    public static final String TAG = "InfoFragment";

    private Context context;

    public static InfoFragment getInstance()
    {
        return new InfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.info_fragment, container, false);
    }


    @Override
    protected void setUp(View view)
    {
        context = getContext();
    }

}
