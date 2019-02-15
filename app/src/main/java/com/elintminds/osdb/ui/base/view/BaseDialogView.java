package com.elintminds.osdb.ui.base.view;

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
    }

    interface ProfileSelectorDialogListener
    {
        void onPersonalProfileClick();
        void onBusinesProfileClick();
        void onDatingProfileClick();
        void onCancelClick();
    }
}
