package com.elintminds.osdb.ui.register.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.login.view.LoginActivity;

public class RegisterFormFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = "RegisterFormFragment";
    private TextView continueBtn;
    private RegisterActivity activity;
    private TextView signinTab;
    private EditText userNameEt, emailEt, phoneNumEt;

    public static RegisterFormFragment newInstance() {
        return new RegisterFormFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.register_form_screen, container, false);
    }

    @Override
    protected void setUp(View view) {
        activity = (RegisterActivity) getActivity();
        continueBtn = view.findViewById(R.id.continue_btn);
        signinTab = view.findViewById(R.id.signin_tab);
        userNameEt = view.findViewById(R.id.signup_name_et);
        emailEt = view.findViewById(R.id.signup_email_et);
        phoneNumEt = view.findViewById(R.id.signup_phn_et);

        continueBtn.setOnClickListener(this);
        signinTab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.continue_btn: {
                if (validate()) {
                    activity.changeFragment(RegisterPasswordFragment.newInstance(), RegisterPasswordFragment.TAG,"2");

                }
                break;
            }

            case R.id.signin_tab:
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
        }
    }


    private Boolean validate() {
        if (userNameEt.getText().toString().isEmpty()) {
            showToast("Please enter username");
            return false;
        } else if (emailEt.getText().toString().isEmpty()) {
            showToast("Please enter your email");
            return false;
        } else if (userNameEt.getText().toString().length() > 15) {
            showToast("Username must be less than of 15 character");
            return false;
        } else if (!getValidateChecksInstance().emailValidator(emailEt.getText().toString())) {
            showToast("Please enter valid email");
            return false;
        } else if (phoneNumEt.getText().toString().trim().length() == 0 || phoneNumEt.getText().toString().trim().length() < 10) {
            showToast("Please enter valid phone number");
            return false;
        } else {
            return true;
        }
    }
}
