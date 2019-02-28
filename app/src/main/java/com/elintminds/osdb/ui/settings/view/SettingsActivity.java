package com.elintminds.osdb.ui.settings.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;

public class SettingsActivity extends BaseActivity implements SettingsView {
    private Toolbar toolbar;
    private TextView headerTxt;
    private ImageView backImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initializeView();


    }

    private void initializeView() {

        headerTxt = findViewById(R.id.header_txt);
        backImg = findViewById(R.id.backImg);
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.settings_container, SettingsFragment.newInstance()).commit();

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.settings_container);
        headerTxt.setText(getResources().getString(R.string.settings));

    }


    @Override
    public void changeFragment(Fragment fragment, String tag) {
        headerTxt.setText(tag);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.settings_container, fragment, tag).addToBackStack(null)
                .commit();

    }
}
