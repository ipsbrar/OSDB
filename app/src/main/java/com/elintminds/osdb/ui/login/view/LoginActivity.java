package com.elintminds.osdb.ui.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.dashboard.view.DashboardActivity;
import com.elintminds.osdb.ui.forgot_password.view.ForgotPasswordActivity;
import com.elintminds.osdb.ui.login.beans.UserBean;
import com.elintminds.osdb.ui.login.presenter.LoginPresenterClass;
import com.elintminds.osdb.ui.register.view.RegisterActivity;
import com.elintminds.osdb.utils.Utils;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginView {

    TextView signInBtn, forgotPassTxt, signUpTab;
    EditText loginEmailEt, loginPassEt;
//    private Toolbar toolbar;
    private ImageView showPassBtn;
    private boolean isPassShown = false;
    private LoginPresenterClass loginPresenterClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeViews();

//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
    }

    private void initializeViews() {
//        toolbar = findViewById(R.id.login_toolbar);
        signInBtn = findViewById(R.id.signin_btn);
        signUpTab = findViewById(R.id.signup_tab);
        forgotPassTxt = findViewById(R.id.forgot_pass_txt);
        loginEmailEt = findViewById(R.id.login_email_et);
        loginPassEt = findViewById(R.id.password_email_et);
        showPassBtn = findViewById(R.id.show_password_btn);

        loginPresenterClass = new LoginPresenterClass(this, this);

        signInBtn.setOnClickListener(this);
        signUpTab.setOnClickListener(this);
        forgotPassTxt.setOnClickListener(this);
        showPassBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signin_btn:
//                if (validate()) {
                loginPresenterClass.sendUserValue(loginEmailEt.getText().toString(), loginPassEt.getText().toString());

//                }
                break;

            case R.id.signup_tab:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
                break;

            case R.id.forgot_pass_txt:
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));

                break;

            case R.id.show_password_btn:
                Utils.showHidePass(loginPassEt, isPassShown);
                isPassShown = !isPassShown;
                break;
        }
    }


    private Boolean validate() {
        if (loginEmailEt.getText().toString().isEmpty()) {
            showToast("Please enter your email");
            return false;
        } else if (loginPassEt.getText().toString().isEmpty()) {
            showToast("Please enter your password");
            return false;
        } else if (!getValidateChecksInstance().emailValidator(loginEmailEt.getText().toString().trim())) {
            showToast("Please enter valid email");
            return false;
        } else if (loginPassEt.getText().toString().length() < 8 || !getValidateChecksInstance().passwordValidator(loginPassEt.getText().toString())) {
            showToast("Password should be of minimum 8 character with atleast 1 capital letter,1 lower letter,1 number & 1 special character");
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void onSuccess(UserBean obj) {
        getAppPreferenceHelperClass().saveLoginStatus(true);
        getAppPreferenceHelperClass().saveToken(obj.getToken());
        Intent intent = new Intent(this, DashboardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


}
