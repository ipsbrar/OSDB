package com.elintminds.osdb.ui.register.view;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;

public class RegisterActivity extends BaseActivity implements RegisterView
{
    private TextView pageCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        intializeViews();

        getSupportFragmentManager().beginTransaction().add(R.id.register_container, RegisterFormFragment.newInstance()).commit();
    }

    private void intializeViews() {
        pageCount = findViewById(R.id.page_count);
    }


    public void changeFragment(Fragment fragment, String tag)
    {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.register_container, fragment, tag)
                .addToBackStack(null)
                .commit();
    }
}
