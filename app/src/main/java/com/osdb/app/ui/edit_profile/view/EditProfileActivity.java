package com.osdb.app.ui.edit_profile.view;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.osdb.app.R;
import com.osdb.app.ui.base.view.BaseActivity;
import com.osdb.app.ui.base.view.BaseDialogView;
import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.base.view.base_dialogs.ImageSelectorDialog;
import com.osdb.app.ui.edit_profile.presenter.EditProfilePresenterClass;
import com.osdb.app.utils.AppConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EditProfileActivity extends BaseActivity implements View.OnClickListener, BaseDialogView.ImageSelectorDialogListener, EditProfileView {

    private int PIC_FROM_GALLERY = 101;
    private int CAPTURE_FROM_CAMERA = 102;
    private static final int REQUEST_WRITE_PERMISSION = 103;
    private static final int MY_CAMERA_PERMISSION_CODE = 104;
    private ImageView backImg, edit_img_btn;
    private CircleImageView profImg;
    private TextView savebtn;
    private String imagePathNew;
    private EditProfilePresenterClass editProfilePresenterClass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        editProfilePresenterClass = new EditProfilePresenterClass(this, this);
        profImg = findViewById(R.id.profImg);
        savebtn = findViewById(R.id.save_btn);
        edit_img_btn = findViewById(R.id.edit_img_btn);
        backImg = findViewById(R.id.back_img);
        backImg.setOnClickListener(this);
        savebtn.setOnClickListener(this);
        edit_img_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.back_img: {
                finish();
                break;
            }

            case R.id.save_btn: {
                editProfilePresenterClass.updateUserValue("EM", "1234567890", imagePathNew);
                break;
            }
            case R.id.edit_img_btn: {
                openDialog();
                break;
            }
        }
    }


    private void openDialog() {
        if (checkAndRequestPermissions()) {
            Log.e("ON CAM CLICK", "" + checkAppPermission(BaseView.CAMERA_PERMISSION));
            callImagePickerDialog();
        } else {
            checkAndRequestPermissions();
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

        Intent pictureIntent = new Intent(
                MediaStore.ACTION_IMAGE_CAPTURE);
        if (pictureIntent.resolveActivity(getPackageManager()) != null) {
            //Create a file to store the image
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        getPackageName() + ".fileprovider", photoFile);
                pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        photoURI);

                startActivityForResult(pictureIntent,
                        CAPTURE_FROM_CAMERA);
            }
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


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("ACT DATA", "" + requestCode);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAPTURE_FROM_CAMERA) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.img_player_empty);
                Glide.with(this).setDefaultRequestOptions(requestOptions)
                        .load(imagePathNew).into(profImg);

                if (data != null && data.getExtras() != null) {
                    Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
                    edit_img_btn.setImageBitmap(imageBitmap);
                }

            } else if (requestCode == PIC_FROM_GALLERY) {

                Uri imgUri = data.getData();
                // val fileName =  File(imgUri!!.path)
                File fileName = new File(AppConstants.getRealPathFromURI(this, imgUri));
                imagePathNew = fileName.getPath();
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.img_player_empty);
                Glide.with(this).setDefaultRequestOptions(requestOptions)
                        .load(imagePathNew).into(profImg);

            }
        }

    }


    private File createImageFile() throws IOException {
        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss",
                        Locale.getDefault()).format(new Date());
        String imageFileName = "IMG_" + timeStamp + "_";
        File storageDir =
                getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        imagePathNew = image.getAbsolutePath();
        return image;
    }


    @Override
    public void updateUserResult(String jsonObject) {
        Toast.makeText(this, "User updated successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error(String error) {

    }
}
