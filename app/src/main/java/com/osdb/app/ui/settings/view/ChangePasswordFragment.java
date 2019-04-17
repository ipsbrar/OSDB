package com.osdb.app.ui.settings.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.osdb.app.R;
import com.osdb.app.ui.base.view.BaseFragment;
import com.osdb.app.ui.settings.presenter.ChangePasswordPresenterClass;

public class ChangePasswordFragment extends BaseFragment implements ChangePasswordView {
    public static String TAG = "ChangePassword";
    private EditText edt_old_password, edt_new_password, edt_confirm_password;
    private ChangePasswordPresenterClass changePasswordPresenterClass;
    private String userID = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.change_password_layout, container, false);
        return view;
    }

    public static ChangePasswordFragment getInstance() {
        return new ChangePasswordFragment();
    }

    @Override
    protected void setUp(View view) {
        edt_old_password = view.findViewById(R.id.edt_old_password);
        edt_new_password = view.findViewById(R.id.edt_new_password);
        edt_confirm_password = view.findViewById(R.id.edt_confirm_password);
        userID = getAppPreferenceHelperClass().getUserId();
        changePasswordPresenterClass = new ChangePasswordPresenterClass(getActivity(), this);
        view.findViewById(R.id.continue_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    String oldPassword = edt_old_password.getText().toString().trim();
                    String newPassword = edt_new_password.getText().toString().trim();
                    changePasswordPresenterClass.getUserDetails(userID, oldPassword, newPassword, newPassword);
                }
            }
        });

    }

    private boolean validate() {
        if (edt_old_password.getText().toString().isEmpty()) {
            showToast("Please enter your password");
            return false;
        } else if (!checkIsPasswordValid(edt_old_password)) {
            showToast("Your password is not correct");
            return false;
        } else if (edt_new_password.getText().toString().isEmpty()) {
            showToast("Please enter your password");
            return false;
        } else if (!checkIsPasswordValid(edt_new_password)) {
            return false;
        } else if (!edt_new_password.getText().toString().trim().equalsIgnoreCase(edt_confirm_password.getText().toString().trim())) {
            showToast("New password or confirm password does not match");
        } else if (userID == null) {
            showToast("Something went wrong");
        }

        return true;
    }

    private boolean checkIsPasswordValid(EditText editText) {
        if (editText.getText().toString().length() < 8 || !getValidateChecksInstance().passwordValidator(editText.getText().toString())) {
            showToast("Password should be of minimum 8 character with atleast 1 capital letter,1 lower letter,1 number & 1 special character");
            return false;
        }
        return true;
    }

    @Override
    public void success(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void error(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }
}
