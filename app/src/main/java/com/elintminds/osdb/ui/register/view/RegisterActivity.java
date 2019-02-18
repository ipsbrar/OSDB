package com.elintminds.osdb.ui.register.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;

public class RegisterActivity extends BaseActivity implements RegisterView, View.OnClickListener {
    private TextView pageCount;
    private ImageView backImg;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        intializeViews();

        getSupportFragmentManager().beginTransaction().add(R.id.register_container, RegisterFormFragment.newInstance()).commit();
    }

    private void intializeViews() {
        pageCount = findViewById(R.id.page_count);
        toolbar = findViewById(R.id.register_toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    public void changeFragment(Fragment fragment, String tag, String pagecount) {
        pageCount.setText(pagecount + " of 2");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.register_container, fragment, tag)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.register_container);
        if (fragment instanceof RegisterPasswordFragment) {
            pageCount.setText("1 of 2");
        }
        super.onBackPressed();

    }
}
