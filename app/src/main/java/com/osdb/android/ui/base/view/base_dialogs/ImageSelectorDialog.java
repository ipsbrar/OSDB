package com.osdb.android.ui.base.view.base_dialogs;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.*;
import com.osdb.android.R;
import com.osdb.android.ui.base.view.BaseDialogFragment;

public class ImageSelectorDialog extends BaseDialogFragment implements View.OnClickListener
{
    public static final String TAG = "ImageSelectorDialog";

    private ImageSelectorDialogListener mListener;

    public static ImageSelectorDialog newInstance()
    {
        return new ImageSelectorDialog();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void setListener(ImageSelectorDialogListener listener){
        mListener = listener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.image_picker_options_dialog, container, false);
    }

    @Override
    protected void setUp(View view)
    {
        view.findViewById(R.id.editBtn).setOnClickListener(this);
        view.findViewById(R.id.deleteBtn).setOnClickListener(this);
        view.findViewById(R.id.camera_picker_btn).setOnClickListener(this);
        view.findViewById(R.id.gallery_picker_btn).setOnClickListener(this);
        view.findViewById(R.id.cancelBtn).setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            window.setGravity(Gravity.BOTTOM);
            window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        }
    }


    @Override
    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.editBtn:
                mListener.editProfileClick();
                dismissDialog();
                break;

                case R.id.camera_picker_btn:
                mListener.onFromCameraClick();
                dismissDialog();
                break;

            case R.id.gallery_picker_btn:
                mListener.onFromGalleryClick();
                dismissDialog();
                break;

                case R.id.deleteBtn:

                dismissDialog();
                break;

            case R.id.cancelBtn:
                dismissDialog();
                break;
        }
    }
}
