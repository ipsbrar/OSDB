package com.elintminds.osdb.ui.profile.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.base.view.BaseDialogView;
import com.elintminds.osdb.ui.base.view.base_dialogs.ImageSelectorDialog;
import com.elintminds.osdb.ui.dashboard.adapters.LatestViewPagerFragment;
import com.elintminds.osdb.ui.search_finding_screen.view.PlayerFragment;
import com.elintminds.osdb.ui.settings.view.SettingsActivity;
import com.elintminds.osdb.utils.AppConstants;
import de.hdodenhof.circleimageview.CircleImageView;

import java.io.File;
import java.io.IOException;

public class ProfileActivity extends BaseActivity implements View.OnClickListener, ProfileView, BaseDialogView.ImageSelectorDialogListener {


    private   int PIC_FROM_GALLERY = 101;
    private   int CAPTURE_FROM_CAMERA = 102;
    private TabLayout tabs;
    private TextView title;
    private ImageView settingsImg, notificationImg,edit_img_btn;
    private String imagePathNew;
    Bitmap bm;
    CircleImageView profImg;
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
        profImg = findViewById(R.id.profImg);
        notificationImg = findViewById(R.id.notification_icon);
        ViewPager viewPager = findViewById(R.id.profile_viewpager);

        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);
        settingsImg.setOnClickListener(this);
        notificationImg.setOnClickListener(this);
        edit_img_btn.setOnClickListener(this);
        setDividerForTabs();
    }

    private void setupViewPager(ViewPager upViewPager) {
        LatestViewPagerFragment adapter = new LatestViewPagerFragment(getSupportFragmentManager());
        adapter.addFragment(MyWatchListFragment.getInstance(), getString(R.string.mywatchlist));
        adapter.addFragment(PlayerFragment.getInstance(), getString(R.string.following));

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

                callImagePickerDialog();
                break;
            }
        }
    }

    private void callImagePickerDialog() {
        ImageSelectorDialog imageSelectorDialog = ImageSelectorDialog.newInstance();
        imageSelectorDialog.setListener(this);
        showDialog(imageSelectorDialog);
    }

    @Override
    public void onFromCameraClick() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
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


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("ACT DATA", "" + requestCode);
        if (requestCode == CAPTURE_FROM_CAMERA) {
            if (resultCode == Activity.RESULT_OK) {

                Log.e("path image", "" + imagePathNew);

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
                    profImg.setImageBitmap(bm);

                }
            } else if (requestCode == PIC_FROM_GALLERY) {
                if (resultCode == Activity.RESULT_OK) {
                    Uri imgUri = data.getData();
                    // val fileName =  File(imgUri!!.path)
                    File fileName = new File(AppConstants.getRealPathFromURI(this, imgUri));
                    try {
                        Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(getContentResolver(), imgUri);
                        profImg.setImageBitmap(bitmapImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}