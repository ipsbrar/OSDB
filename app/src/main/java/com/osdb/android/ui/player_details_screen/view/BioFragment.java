package com.osdb.android.ui.player_details_screen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.NestedScrollView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.osdb.android.R;
import com.osdb.android.ui.base.view.BaseFragment;

public class BioFragment extends BaseFragment {
    public static final String TAG = "BioFragment";

    //no  data found
    private ConstraintLayout no_data;
    private TextView txt_no_data_title, txt_no_data_disp;

    private Context context;
    private TextView bioText;

    private NestedScrollView nscrollBio;

    public static BioFragment getInstance(String bio) {
        BioFragment bioFragment = new BioFragment();
        Bundle bundle = new Bundle();
        bundle.putString("bioText", bio);
        bioFragment.setArguments(bundle);
        return bioFragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bio_fragment, container, false);
    }


    @Override
    protected void setUp(View view) {
        context = getContext();
        bioText = view.findViewById(R.id.txt_bio);
        nscrollBio = view.findViewById(R.id.nscrollBio);

        //        No data found Views
        txt_no_data_title = view.findViewById(R.id.txt_no_data_title);
        txt_no_data_disp = view.findViewById(R.id.txt_no_data_disp);
        no_data = view.findViewById(R.id.no_data);
        txt_no_data_title.setText(getString(R.string.no_data_found));
        txt_no_data_disp.setText(getString(R.string.please_try_again));
        no_data.setVisibility(View.GONE);

        Bundle bundle = getArguments();
        if (bundle != null && bundle.getString("bioText") != null && !bundle.getString("bioText").equalsIgnoreCase("")) {
            no_data.setVisibility(View.GONE);
            nscrollBio.setVisibility(View.VISIBLE);
            bioText.setText(Html.fromHtml(bundle.getString("bioText")));
        } else {
            no_data.setVisibility(View.VISIBLE);
            nscrollBio.setVisibility(View.GONE);
        }

//        bioText.setMovementMethod(new ScrollingMovementMethod());
    }
}
