package com.elintminds.osdb.ui.base.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.utils.ValidationChecks;

public abstract class BaseFragment extends Fragment implements BaseView {
    private BaseActivity mActivity;
    private ValidationChecks validationChecks;
    private AppPreferenceHelperClass appPreferenceHelperClass;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.mActivity = (BaseActivity) context;
            validationChecks = new ValidationChecks(context);
            appPreferenceHelperClass=new AppPreferenceHelperClass(context);
        }
    }

    @Override
    public ValidationChecks getValidateChecksInstance() {
        return validationChecks;
    }

    @Override
    public void showProgressDialog() {
        if (mActivity != null) {
            mActivity.showProgressDialog();
        }
    }

    @Override
    public void hideProgressDialog() {
        if (mActivity != null) {
            mActivity.hideProgressDialog();
        }
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void setupUITouch(View view) {
        if (mActivity != null) {
            mActivity.setupUITouch(view);
        }
    }


    @Override
    public void showDialog(BaseDialogView dialogView) {
        if (mActivity != null) {
            mActivity.showDialog(dialogView);
        }
    }

    @Override
    public void hideDialog() {
        if (mActivity != null) {
            mActivity.hideDialog();
        }
    }

    @Override
    public BaseDialogView getDialogInstance() {
        if (mActivity != null) {
            return mActivity.getDialogInstance();
        }
        return null;
    }

    @Override
    public void showSnackBar(String msg) {

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getContext(),msg, Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void showSnackBar(String msg)
//    {
//        if (mActivity != null)
//        {
//            mActivity.showSnackBar(msg);
//        }
//    }
//
//    @Override
//    public void showToast(String msg)
//    {
//        if (mActivity != null)
//        {
//            mActivity.showToast(msg);
//        }
//    }

    @Override
    public void hideKeyBoard(View v) {
        if (mActivity != null) {
            mActivity.hideKeyBoard(v);
        }
    }


    @Override
    public void showSystemUI() {
        if (mActivity != null) {
            mActivity.showSystemUI();
        }
    }


    @Override
    public void hideSystemUI() {
        if (mActivity != null) {
            mActivity.hideSystemUI();
        }
    }

    @Override
    public boolean checkAppPermission(String[] reqPermissions) {

        return mActivity != null && mActivity.checkAppPermission(reqPermissions);
    }

    @Override
    public boolean checkPreviouslyDenied(String[] reqPermissions) {
        return mActivity != null && mActivity.checkPreviouslyDenied(reqPermissions);
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }


    protected abstract void setUp(View view);

    public AppPreferenceHelperClass getAppPreferenceHelperClass(){
        return appPreferenceHelperClass;
    }
}
