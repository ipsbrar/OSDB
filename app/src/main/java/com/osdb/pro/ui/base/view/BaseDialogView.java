package com.osdb.pro.ui.base.view;

import android.support.v4.app.FragmentManager;

public interface BaseDialogView extends BaseView
{
    void dismissDialog();
    void show(FragmentManager fragmentManager);

    interface ViewListener
    {
        void onViewClosed();
    }

    interface ImageSelectorDialogListener
    {
        void onFromCameraClick();
        void onFromGalleryClick();
        void deleteImg();
        void editProfileClick();
    }

    interface ConfirmationDialogListener{
        void onConfirmOkClick(int dialogId);
    }
}
