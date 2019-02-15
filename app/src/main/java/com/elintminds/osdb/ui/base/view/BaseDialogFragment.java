package com.elintminds.osdb.ui.base.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.elintminds.osdb.R;
import com.elintminds.osdb.utils.ValidationChecks;

public abstract class BaseDialogFragment extends DialogFragment implements BaseDialogView {

    private BaseActivity mActivity;
    private Context context;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.context = context;
            this.mActivity = (BaseActivity) context;
        }
    }

    @Override
    public void dismissDialog()
    {
        try {
            dismiss();
        }catch (Exception e){
            Log.e("DISMISS",""+e.toString());
        }

    }

    @Override
    public ValidationChecks getValidateChecksInstance() {
        if(mActivity != null) {
            return mActivity.getValidateChecksInstance();
        }
        return null;
    }

    @Override
    public void showProgressDialog() {
        if(mActivity!= null){
            mActivity.showProgressDialog();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

    }

    @Override
    public void hideProgressDialog() {
        if(mActivity!= null){
            mActivity.hideProgressDialog();
        }
    }

    @Override
    public void showError(String msg)
    {
        if(mActivity!= null){
            mActivity.showError(msg);
        }
    }

    @Override
    public void setupUITouch(View view) {
        if(mActivity != null)
        {
            mActivity.setupUITouch(view);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setCanceledOnTouchOutside(false);

        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        return dialog;
    }

    protected abstract void setUp(View view);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }


    public void show(FragmentManager fragmentManager, String tag)
    {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment prevFragment = fragmentManager.findFragmentByTag(tag);
        if (prevFragment != null) {
            transaction.remove(prevFragment);
        }
        transaction.addToBackStack(tag);
        show(transaction, tag);
    }


    @Override
    public void hideKeyBoard(View v)
    {
        if(mActivity != null)
        {
            mActivity.hideKeyBoard(v);
        }
    }



    @Override
    public void showDialog(BaseDialogView dialogView) {
        if(mActivity!= null){
            mActivity.showDialog(dialogView);
        }
    }

    @Override
    public void hideDialog() {
        if(mActivity!= null){
            mActivity.hideDialog();
        }
    }

    @Override
    public BaseDialogView getDialogInstance() {
        if(mActivity!= null){
            return mActivity.getDialogInstance();
        }
        return null;
    }

    @Override
    public void showSnackBar(String msg) {
        if (msg != null) {
            if(getView() != null)
                Snackbar.make(getView(), msg, Snackbar.LENGTH_LONG).show();
        } else {
            if(getView() != null)
                Snackbar.make(getView(), getString(R.string.some_error), Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void showToast(String msg)
    {
        if (mActivity != null)
        {
            mActivity.showToast(msg);
        }
    }

    @Override
    public void showSystemUI()
    {
        if (mActivity != null)
        {
            mActivity.showSystemUI();
        }
    }


    @Override
    public void hideSystemUI()
    {
        if (mActivity != null)
        {
            mActivity.hideSystemUI();
        }
    }

    @Override
    public boolean checkAppPermission(String[] reqPermissions)
    {

        return mActivity != null && mActivity.checkAppPermission(reqPermissions);
    }

    @Override
    public boolean checkPreviouslyDenied(String[] reqPermissions)
    {
        return mActivity != null && mActivity.checkPreviouslyDenied(reqPermissions);
    }


}
