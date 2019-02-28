package com.elintminds.osdb.ui.settings.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;

public class FeedbackFragment extends BaseFragment implements View.OnClickListener {

    public static String TAG = "Feedback";

    private TextView addBtn;
    public static FeedbackFragment getInstance() {
        return new FeedbackFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.feedback_fragment_view, container, false);
    }

    @Override
    protected void setUp(View view) {


        addBtn = view.findViewById(R.id.add_btn);
        addBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.add_btn: {

                ((SettingsActivity)getContext()).getSupportFragmentManager().popBackStackImmediate();
                break;
            }

        }
    }
}
