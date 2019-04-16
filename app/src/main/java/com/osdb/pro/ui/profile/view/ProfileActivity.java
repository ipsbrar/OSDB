package com.osdb.pro.ui.profile.view;

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
import com.osdb.pro.R;
import com.osdb.pro.ui.base.view.BaseActivity;
import com.osdb.pro.ui.base.view.BaseDialogView;
import com.osdb.pro.ui.base.view.BaseView;
import com.osdb.pro.ui.base.view.base_dialogs.ImageSelectorDialog;
import com.osdb.pro.ui.dashboard.adapters.LatestViewPagerFragment;
import com.osdb.pro.ui.edit_profile.view.EditProfileActivity;
import com.osdb.pro.ui.profile.beans.UserInfo;
import com.osdb.pro.ui.profile.presenter.ProfilePresenterClass;
import com.osdb.pro.ui.settings.view.SettingsActivity;
import com.osdb.pro.utils.AppConstants;
import de.hdodenhof.circleimageview.CircleImageView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends BaseActivity implements View.OnClickListener, ProfileView, BaseDialogView.ImageSelectorDialogListener {


    private int PIC_FROM_GALLERY = 101;
    private int CAPTURE_FROM_CAMERA = 102;
    private static final int REQUEST_WRITE_PERMISSION = 103;
    private static final int MY_CAMERA_PERMISSION_CODE = 104;
    private TabLayout tabs;
    private TextView title;
    private ImageView settingsImg, notificationImg, edit_img_btn, backImg;
    private String imagePathNew;
    Bitmap bm;
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

        profilePresenterClass = new ProfilePresenterClass(this,this);

        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);
        settingsImg.setOnClickListener(this);
        notificationImg.setOnClickListener(this);
        edit_img_btn.setOnClickListener(this);
        backImg.setOnClickListener(this);
        setDividerForTabs();

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

                if (checkAndRequestPermissions()) {
                    Log.e("ON CAM CLICK", "" + checkAppPermission(BaseView.CAMERA_PERMISSION));
                    callImagePickerDialog();
                } else {
                    checkAndRequestPermissions();
                }
                break;
            }

            case R.id.back_img: {

                finish();
                break;
            }
        }
    }

    private boolean checkAndRequestPermissions() {
        int camera = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA);
        int storage = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (camera != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.CAMERA);
        }
        if (storage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray
                    (new String[listPermissionsNeeded.size()]), MY_CAMERA_PERMISSION_CODE);
            return false;
        }
        return true;
    }

    private void callImagePickerDialog() {
        ImageSelectorDialog imageSelectorDialog = ImageSelectorDialog.newInstance();
        imageSelectorDialog.setListener(this);
        showDialog(imageSelectorDialog);
    }

    @Override
    public void onFromCameraClick() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            Uri fileUri = AppConstants.getOutputMediaFileUri(this);
            if (fileUri != null) {
                imagePathNew = fileUri.getPath();
            }
            Log.e("PATH", "" + imagePathNew);
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            startActivityForResult(cameraIntent, CAPTURE_FROM_CAMERA);
        }
    }

    @Override
    public void onFromGalleryClick() {
        Intent intent = new Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(
                Intent.createChooser(intent, "Select File"),
                PIC_FROM_GALLERY);
    }

    @Override
    public void deleteImg() {

    }

    @Override
    public void editProfileClick() {
        startActivity(new Intent(this, EditProfileActivity.class));
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("ACT DATA", "" + requestCode);
        if (requestCode == CAPTURE_FROM_CAMERA) {
            if (resultCode == Activity.RESULT_OK) {


                if (imagePathNew != null) {
                    bm = AppConstants.decodeBitmapFromSDCard(imagePathNew, 200, 200);
                    int rotation = AppConstants.rotationAngle(imagePathNew);
                    if (rotation != 0) {
                        Matrix mat = new Matrix();
                        mat.postRotate(rotation);
                        Bitmap rotatedBitmap = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), mat, true);
                        bm.recycle();
                        if (rotatedBitmap != null)
                            bm = rotatedBitmap;
                    }

                }

                if (bm != null) {
                    Uri imgUri = AppConstants.getImageUri(this, bm);
                    File finalFile = new File(AppConstants.getRealPathFromURI(this, imgUri));
                    Log.e("path image", "" + finalFile);
                    try {
                        Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(getContentResolver(), imgUri);
                        Log.e("path image", "" + finalFile);
                        profImg.setImageBitmap(bitmapImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        } else if (requestCode == PIC_FROM_GALLERY) {
            if (resultCode == Activity.RESULT_OK) {
                Uri imgUri = data.getData();
                // val fileName =  File(imgUri!!.path)
                File fileName = new File(AppConstants.getRealPathFromURI(this, imgUri));
                try {
                    Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(getContentResolver(), imgUri);
                    Log.e("path image", "" + fileName);
                    profImg.setImageBitmap(bitmapImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_CAMERA_PERMISSION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    callImagePickerDialog();
                }
                break;
        }
    }


    @Override
    public void success(UserInfo userBean) {
        getAppPreferenceHelperClass().saveUserId(String.valueOf(userBean.getUser().getId()));
        txt_user_name.setText(userBean.getUser().getName());

    }

    @Override
    public void error(String error) {
        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
    }
}