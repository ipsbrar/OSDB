package com.elintminds.osdb.ui.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.elintminds.osdb.MainActivity;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.forgot_password.view.ForgotPasswordActivity;
import com.elintminds.osdb.ui.register.view.RegisterActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    TextView signInBtn, forgotPassTxt, signUpTab;
    EditText loginEmailEt, loginPassEt;
    ImageView crossImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInBtn = findViewById(R.id.signin_btn);
        signUpTab = findViewById(R.id.signup_tab);
        forgotPassTxt = findViewById(R.id.forgot_pass_txt);
        loginEmailEt = findViewById(R.id.login_email_et);
        loginPassEt = findViewById(R.id.password_email_et);
        crossImg = findViewById(R.id.crossImg);


        signInBtn.setOnClickListener(this);
        signUpTab.setOnClickListener(this);
        forgotPassTxt.setOnClickListener(this);
        crossImg.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.signin_btn: {
                if (validate()) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
                break;
            }

            case R.id.signup_tab: {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
                break;
            }

            case R.id.forgot_pass_txt: {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));

                break;
            }

            case R.id.crossImg :{
                finish();
            }
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
}
