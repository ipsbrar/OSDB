package com.osdb.pro.ui.base.view.base_dialogs;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.osdb.pro.R;
import com.osdb.pro.ui.base.view.BaseDialogFragment;

public class ConfirmationDialog extends BaseDialogFragment implements View.OnClickListener {

    public static final String TAG = "ConfirmationDialog";

    private Bundle args;
    private ConfirmationDialogListener mListener;
    private View sourceView;

    public static ConfirmationDialog newInstance(Bundle args) {
        ConfirmationDialog dialog = new ConfirmationDialog();
        dialog.setArguments(args);
        return dialog;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        args = getArguments();
    }


    public void setListener(ConfirmationDialogListener listener) {
        mListener = listener;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_view, container, false);
    }

    @Override
    protected void setUp(View view) {
        TextView title = view.findViewById(R.id.textview_title);
        TextView note = view.findViewById(R.id.textview_content);
        TextView okBtn = view.findViewById(R.id.tv_Save);

        title.setText(args.getString("DIALOG_TITLE"));
        note.setText(args.getString("MESSAGE"));
        okBtn.setText(args.getString("BUTTON_TEXT"));
        okBtn.setOnClickListener(this);
        view.findViewById(R.id.tv_cancel).setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }



    @Override
    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_Save:
                mListener.onConfirmOkClick(args.getInt("CONF_OF"));
                dismissDialog();
                break;

            case R.id.tv_cancel:
                dismissDialog();
                break;
        }
    }


}
