package com.osdb.pro.ui.settings.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.osdb.pro.R;
import com.osdb.pro.ui.base.view.BaseFragment;

public class FeedbackFragment extends BaseFragment implements View.OnClickListener {

    public static String TAG = "Feedback";
    private EditText title_et, email_et, message_et;
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
        title_et = view.findViewById(R.id.title_et);
        email_et = view.findViewById(R.id.email_et);
        message_et = view.findViewById(R.id.message_et);
        addBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.add_btn: {
                if (checkValidation()) {

                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_EMAIL, new String[]{"support@osdbsports.com"});
                    i.putExtra(Intent.EXTRA_SUBJECT, title_et.getText().toString().trim());
                    i.putExtra(Intent.EXTRA_TEXT, message_et.getText().toString().trim());
                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }
//                    ((SettingsActivity) getContext()).getSupportFragmentManager().popBackStackImmediate();
                }
                break;
            }

        }
    }

    private boolean checkValidation() {
        if (TextUtils.isEmpty(title_et.getText().toString())) {
            Toast.makeText(getActivity(), "Please add your name", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(email_et.getText().toString())) {
            Toast.makeText(getActivity(), "Please add your email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(message_et.getText().toString())) {
            Toast.makeText(getActivity(), "Please add your feedback message", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
