package com.elintminds.osdb.ui.login_options.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.login.view.LoginActivity;
import com.elintminds.osdb.ui.register.view.RegisterActivity;

public class LoginOptionsActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout createAccountBtn;
    private TextView signInTab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_options);

        initializeViews();
    }

    private void initializeViews()
    {
        createAccountBtn = findViewById(R.id.create_account_lay);
        signInTab = findViewById(R.id.signin_tab);

        createAccountBtn.setOnClickListener(this);
        signInTab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.create_account_lay:
                startActivity(new Intent(this, RegisterActivity.class));
                break;

            case R.id.signin_tab:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
