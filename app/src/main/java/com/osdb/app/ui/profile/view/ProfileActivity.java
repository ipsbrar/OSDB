package com.osdb.app.ui.profile.view;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.osdb.app.R;
import com.osdb.app.ui.base.view.BaseActivity;
import com.osdb.app.ui.base.view.BaseDialogView;
import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.base.view.base_dialogs.ImageSelectorDialog;
import com.osdb.app.ui.dashboard.adapters.LatestViewPagerFragment;
import com.osdb.app.ui.edit_profile.view.EditProfileActivity;
import com.osdb.app.ui.profile.beans.UserInfo;
import com.osdb.app.ui.profile.presenter.ProfilePresenterClass;
import com.osdb.app.ui.settings.view.SettingsActivity;
import com.osdb.app.utils.AppConstants;
import de.hdodenhof.circleimageview.CircleImageView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends BaseActivity implements View.OnClickListener, ProfileView {


    private TabLayout tabs;
    private TextView title;
    private ImageView settingsImg, notificationImg, edit_img_btn, backImg;
    private String imagePathNew;

    CircleImageView profImg;
    private ProfilePresenterClass profilePresenterClass;
    private TextView txt_user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initializeViews();


    }

    private void initializeViews() {

        tabs = findViewById(R.id.profile_tabs);
        settingsImg = findViewById(R.id.settings_icon);
        edit_img_btn = findViewById(R.id.edit_img_btn);
        backImg = findViewById(R.id.back_img);
        profImg = findViewById(R.id.profImg);
        txt_user_name = findViewById(R.id.txt_user_name);
        notificationImg = findViewById(R.id.notification_icon);
        ViewPager viewPager = findViewById(R.id.profile_viewpager);

        profilePresenterClass = new ProfilePresenterClass(this, this);

        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);
        settingsImg.setOnClickListener(this);
        notificationImg.setOnClickListener(this);
        edit_img_btn.setOnClickListener(this);
        backImg.setOnClickListener(this);
        setDividerForTabs();


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (profilePresenterClass != null)
            profilePresenterClass.getUserInfo();
    }

    private void setupViewPager(ViewPager upViewPager) {
        LatestViewPagerFragment adapter = new LatestViewPagerFragment(getSupportFragmentManager());
        adapter.addFragment(MyWatchListFragment.getInstance(), getString(R.string.mywatchlist));
        adapter.addFragment(FollowingFragment.getInstance(), getString(R.string.following));

        upViewPager.setAdapter(adapter);
    }

    private void setDividerForTabs() {
        View root = tabs.getChildAt(0);
        if (root instanceof LinearLayout) {
            ((LinearLayout) root).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(getResources().getColor(R.color.color_EFEFEF));
            drawable.setSize(2, 1);
            ((LinearLayout) root).setDividerPadding(0);
            ((LinearLayout) root).setDividerDrawable(drawable);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {

        switch (view.getId()) {


            case R.id.settings_icon: {

                startActivity(new Intent(ProfileActivity.this, SettingsActivity.class));
                break;
            }

            case R.id.notification_icon: {

                startActivity(new Intent(ProfileActivity.this, NotificationActivity.class));
                break;
            }

            case R.id.edit_img_btn: {
                startActivity(new Intent(this, EditProfileActivity.class));
                break;
            }

            case R.id.back_img: {

                finish();
                break;
            }
        }
    }


    @Override
    public void success(UserInfo userBean) {
        getAppPreferenceHelperClass().saveUserId(String.valueOf(userBean.getUser().getId()));
        txt_user_name.setText(userBean.getUser().getName());

    }

    @Override
    public void error(String error) {
        Toast.makeText(this, "" + error, Toast.LENGTH_SHORT).show();
    }
}