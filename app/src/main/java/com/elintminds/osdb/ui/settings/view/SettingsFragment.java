package com.elintminds.osdb.ui.settings.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.elintminds.osdb.R;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.login.view.LoginActivity;
import com.elintminds.osdb.ui.login_options.view.LoginOptionsActivity;

import java.util.Objects;

public class SettingsFragment extends BaseFragment implements View.OnClickListener {

    private CardView changePassView, helpView, feedbackView, privacyView, termsView, logoutView;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settings_fragment_view, container, false);
    }

    @Override
    protected void setUp(View view) {

        changePassView = view.findViewById(R.id.change_pass_view);
        helpView = view.findViewById(R.id.help_view);
        feedbackView = view.findViewById(R.id.feedback_view);
        privacyView = view.findViewById(R.id.privacy_policy_view);
        termsView = view.findViewById(R.id.term_condition_view);
        logoutView = view.findViewById(R.id.logout_view);

        changePassView.setOnClickListener(this);
        helpView.setOnClickListener(this);
        feedbackView.setOnClickListener(this);
        privacyView.setOnClickListener(this);
        termsView.setOnClickListener(this);
        logoutView.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.change_pass_view: {

                ((SettingsView) Objects.requireNonNull(getContext())).changeFragment(ChangePasswordFragment.getInstance(), ChangePasswordFragment.TAG);
                break;
            }
            case R.id.feedback_view: {

                ((SettingsView) Objects.requireNonNull(getContext())).changeFragment(FeedbackFragment.getInstance(), FeedbackFragment.TAG);
                break;
            }

            case R.id.term_condition_view: {

                ((SettingsView) Objects.requireNonNull(getContext()))
                        .changeFragment(TermsConditionFragment.newInstance("https://dev.osdb.pro/terms"), TermsConditionFragment.TAG);
                break;
            }

            case R.id.help_view: {

                ((SettingsView) Objects.requireNonNull(getContext())).changeFragment(FeedbackFragment.getInstance(), "Help");
                break;
            }

            case R.id.privacy_policy_view: {

                ((SettingsView) Objects.requireNonNull(getContext()))
                        .changeFragment(TermsConditionFragment.newInstance("https://dev.osdb.pro/privacy-policy"), getResources()
                                .getString(R.string.privacy_policy));
                break;
            }

            case R.id.logout_view: {
                getAppPreferenceHelperClass().clearUserData();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);


            }

        }
    }


}
