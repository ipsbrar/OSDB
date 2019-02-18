package com.elintminds.osdb.ui.login.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.elintminds.osdb.MainActivity;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.dashboard.view.DashboardActivity;
import com.elintminds.osdb.ui.forgot_password.view.ForgotPasswordActivity;
import com.elintminds.osdb.ui.register.view.RegisterActivity;

public class LoginActivity extends BaseActivity {

    TextView signInBtn,forgotPassTxt,signUpTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInBtn=findViewById(R.id.signin_btn);
        signUpTab=findViewById(R.id.signup_tab);
        forgotPassTxt=findViewById(R.id.forgot_pass_txt);



        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                finish();
            }
        });

        signUpTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });

        forgotPassTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
            }
        });



    }
}
