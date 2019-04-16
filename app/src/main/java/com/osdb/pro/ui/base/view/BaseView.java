package com.osdb.pro.ui.base.view;

import android.Manifest;
import android.view.View;
import com.osdb.pro.utils.ValidationChecks;

public interface BaseView
{
    int VIDEO_DELETED = 201;
    int VIDEO_EDITED = 202;

    String [] PERMISSIONS = {Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    String [] CAMERA_PERMISSION = {
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    ValidationChecks getValidateChecksInstance();

    void showProgressDialog();
    void hideProgressDialog();
    void showError(String msg);
    void setupUITouch(final View view);

    void showDialog(BaseDialogView dialogView);
    void hideDialog();
    BaseDialogView getDialogInstance();
//
   void showSnackBar(String msg);
    void showToast(String msg);

    void hideKeyBoard(View v);

    boolean checkAppPermission(String[] reqPermissions);

    boolean checkPreviouslyDenied(String[] reqPermissions);

    void showSystemUI();
    void hideSystemUI();

}
