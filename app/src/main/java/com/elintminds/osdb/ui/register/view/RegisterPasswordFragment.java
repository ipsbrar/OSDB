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
import com.elintminds.osdb.MainActivity;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;

public class RegisterPasswordFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = "RegisterPasswordFragment";
    private TextView createAccountBtn;
    private EditText signupPassEt, signupConfPassEt;

    public static RegisterPasswordFragment newInstance() {
        return new RegisterPasswordFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_password_layout, container, false);
        return view;
    }

    @Override
    protected void setUp(View view) {
        createAccountBtn = view.findViewById(R.id.createAccountBtn);
        signupPassEt = view.findViewById(R.id.signupPassEt);
        signupConfPassEt = view.findViewById(R.id.signupConfPassEt);

        createAccountBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.createAccountBtn: {
                if (validate()) {
                    startActivity(new Intent(getContext(), MainActivity.class));
                }
                break;
            }
        }
    }

    private Boolean validate() {

        if (signupPassEt.getText().toString().isEmpty()) {
            showToast("Please enter your password");
            return false;
        } else if (signupConfPassEt.getText().toString().isEmpty()) {
            showToast("Please enter confirm password");
            return false;
        } else if (signupPassEt.getText().toString().length() < 8 || !getValidateChecksInstance().passwordValidator(signupPassEt.getText().toString())) {
            showToast("Password should be of minimum 8 character with atleast 1 capital letter,1 lower letter,1 number & 1 special character");
            return false;
        } else if (!signupPassEt.getText().toString().equals(signupConfPassEt.getText().toString())) {
            showToast("Password not matched");
            return false;
        } else {
            return true;
        }
    }


}
