package com.elintminds.osdb.ui.forgot_password.view;

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
import com.elintminds.osdb.ui.forgot_password.presenter.ForgotPasswordPresenterClass;
import com.elintminds.osdb.ui.register.view.RegisterActivity;

public class ForgotPasswordActivity extends BaseActivity implements View.OnClickListener,ForgotPasswordView
{
    TextView submitBtn, signupTab;
    EditText forgotEmailEt;
    private Toolbar toolbar;
    private ForgotPasswordPresenterClass forgotPasswordPresenterClass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initializeViews();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initializeViews()
    {
        toolbar = findViewById(R.id.forgot_password_toolbar);
        submitBtn = findViewById(R.id.submit_btn);
        signupTab = findViewById(R.id.signup_tab);
        forgotEmailEt = findViewById(R.id.forgot_email);

        forgotPasswordPresenterClass = new ForgotPasswordPresenterClass(this,this);

        submitBtn.setOnClickListener(this);
        signupTab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.submit_btn:
                if (forgotEmailEt.getText().toString().isEmpty())
                {
                    showToast("Please enter your email");
                }
                else if (!getValidateChecksInstance().emailValidator(forgotEmailEt.getText().toString().trim()))
                {
                    showToast("Please enter valid email");
                }
                else {
                    forgotPasswordPresenterClass.getEmailToSendResetLink(forgotEmailEt.getText().toString().trim(),this);
                }
                break;

            case R.id.signup_tab:
                startActivity(new Intent(ForgotPasswordActivity.this, RegisterActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void success(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void error(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
