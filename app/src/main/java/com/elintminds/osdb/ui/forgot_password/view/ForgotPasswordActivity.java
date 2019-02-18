package com.elintminds.osdb.ui.forgot_password.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.register.view.RegisterActivity;

public class ForgotPasswordActivity extends BaseActivity {

    TextView submitBtn, signupTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        submitBtn = findViewById(R.id.submit_btn);
        signupTab = findViewById(R.id.signup_tab);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });


        signupTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForgotPasswordActivity.this, RegisterActivity.class));
                finish();
            }
        });
    }
}
