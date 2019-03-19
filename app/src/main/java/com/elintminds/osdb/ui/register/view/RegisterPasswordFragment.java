package com.elintminds.osdb.ui.register.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.elintminds.osdb.R;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.dashboard.view.DashboardActivity;
import com.elintminds.osdb.ui.login.view.LoginActivity;
import com.elintminds.osdb.ui.register.beans.RegisterBean;
import com.elintminds.osdb.ui.register.presenter.RegisterPresenterClass;
import com.elintminds.osdb.utils.Utils;

public class RegisterPasswordFragment extends BaseFragment implements RegisterView, View.OnClickListener {
    public static final String TAG = "RegisterPasswordFragment";
    private TextView createAccountBtn;
    private EditText signupPassEt, signupConfPassEt;
    private ImageView showPassBtn, showConfPassBtn;
    private boolean isPassShown = false, isConfPassShown = false;
    private RegisterPresenterClass registerPresenterClass;
    private String userName,userEmail,userNumber;
    public static RegisterPasswordFragment newInstance(String name, String email, String phoneNumber) {
//        userName=name;
        RegisterPasswordFragment registerPasswordFragment=new RegisterPasswordFragment();
        Bundle bundle=new Bundle();
        bundle.putString("name",name);
        bundle.putString("email",email);
        bundle.putString("phoneNumber",phoneNumber);
        registerPasswordFragment.setArguments(bundle);
        return registerPasswordFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_password_layout, container, false);
        return view;
    }

    @Override
    protected void setUp(View view)
    {

        userName = getArguments() != null ? getArguments().getString("name") : "";
        userEmail = getArguments() != null ? getArguments().getString("email") : "";
        userNumber = getArguments() != null ? getArguments().getString("phoneNumber") : "";

        createAccountBtn = view.findViewById(R.id.createAccountBtn);
        signupPassEt = view.findViewById(R.id.signupPassEt);
        signupConfPassEt = view.findViewById(R.id.signupConfPassEt);
        showPassBtn = view.findViewById(R.id.show_password_btn);
        showConfPassBtn = view.findViewById(R.id.show_conf_password_btn);

        registerPresenterClass=new RegisterPresenterClass(getActivity(),this);


        createAccountBtn.setOnClickListener(this);
        showPassBtn.setOnClickListener(this);
        showConfPassBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.createAccountBtn:
                if (validate()) {
                    registerPresenterClass.getRegisterData(userName,userEmail,signupPassEt.getText().toString().trim(),userNumber,"1");
                }
                break;

            case R.id.show_password_btn:
                Utils.showHidePass(signupPassEt, isPassShown);
                isPassShown = !isPassShown;
                break;

            case R.id.show_conf_password_btn:
                Utils.showHidePass(signupConfPassEt, isConfPassShown);
                isConfPassShown = !isConfPassShown;
                break;
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
        } else if (userName.equalsIgnoreCase("") || userName.equalsIgnoreCase("") || userName.equalsIgnoreCase("")) {
            showToast("Something went wrong");
            return false;
        }else {
            return true;
        }
    }


    @Override
    public void getSuccess(RegisterBean registerBean) {
//        getAppPreferenceHelperClass().saveToken(registerBean.getVerification_code());
//        getAppPreferenceHelperClass().saveUserId(registerBean.getVerification_code());
//        getAppPreferenceHelperClass().saveLoginStatus(true);
//        Intent intent=new Intent(getActivity(), DashboardActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);

        if (getActivity() != null) {
            Toast.makeText(getActivity(), getString(R.string.verification_link), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(), LoginActivity.class));
            getActivity().finish();
        }

    }

    @Override
    public void getError(String msg) {

    }
}
