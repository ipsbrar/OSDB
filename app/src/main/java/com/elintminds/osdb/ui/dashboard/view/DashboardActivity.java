package com.elintminds.osdb.ui.dashboard.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.register.view.RegisterFormFragment;

public class DashboardActivity extends BaseActivity implements DashboardView {

    private TextView mTextMessage;
    private Toolbar toolbar;
    private String currentFrag = "Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initialzeViews();

        getSupportFragmentManager().beginTransaction().add(R.id.dashboard_container, HomeFragment.newInstance()).commit();
    }

    private void initialzeViews()
    {
        toolbar = findViewById(R.id.dashboard_toolbar);
        mTextMessage = findViewById(R.id.dashboard_title);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    changeFragment(HomeFragment.newInstance(), HomeFragment.TAG);
                    return true;
                case R.id.navigation_latest:
                    mTextMessage.setText(R.string.title_latest);
                    return true;
                case R.id.navigation_live_scores:
                    mTextMessage.setText(R.string.title_live_scores);
                    return true;
                case R.id.navigation_poll:
                    mTextMessage.setText(R.string.title_poll);
                    return true;
                case R.id.navigation_discussion:
                    mTextMessage.setText(R.string.title_discussion);
                    return true;
            }
            return false;
        }
    };

    public void changeFragment(Fragment fragment, String tag)
    {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.dashboard_container, fragment, tag)
                .commit();
    }

}
