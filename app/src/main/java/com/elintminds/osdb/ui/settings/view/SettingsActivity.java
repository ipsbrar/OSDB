package com.elintminds.osdb.ui.settings.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;

public class SettingsActivity extends BaseActivity {
    private Toolbar toolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initializeView();


    }

    private void initializeView() {

        getSupportFragmentManager().beginTransaction().add(R.id.dashboard_container, SettingsFragment.newInstance()).commit();



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    public void changeFragment(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.settings_container, fragment, tag)
                .commit();
    }

}
