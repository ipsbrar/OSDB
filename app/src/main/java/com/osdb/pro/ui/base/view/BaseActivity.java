package com.osdb.pro.ui.base.view;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.osdb.pro.R;
import com.osdb.pro.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.pro.utils.ValidationChecks;


public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    private ProgressDialog pDialog;
    private BaseDialogView mDialogView;
    private ValidationChecks validationChecks;
    private Context context;
    private AppPreferenceHelperClass appPreferenceHelperClass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        validationChecks = new ValidationChecks(context);
        appPreferenceHelperClass=new AppPreferenceHelperClass(context);
    }

    @Override
    public void showProgressDialog() {
        if (isFinishing()) {
            pDialog = null;
            return;
        }
        if (pDialog == null) {
            pDialog = ProgressDialog.show(this, null, null);
            if (pDialog.getWindow() != null) {
                pDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            pDialog.setContentView(new ProgressBar(this));
//            pDialog.setIndeterminate(true);
//            pDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progress_drawable));
            pDialog.setCancelable(false);
            pDialog.setCanceledOnTouchOutside(false);
        }
    }

    @Override
    public void hideProgressDialog() {
        if (isFinishing()) {
            pDialog = null;
            return;
        }
        if ((pDialog != null) && pDialog.isShowing()) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public void setupUITouch(final View view) {
        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideKeyBoard(view);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUITouch(innerView);
            }
        }
    }


    @Override
    public void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String message) {
        if (message != null) {
            showSnackBar(message);
        } else {
            showSnackBar("Error");
        }
    }

    @Override
    public ValidationChecks getValidateChecksInstance() {
        return validationChecks;
    }


    @Override
    public void showDialog(BaseDialogView dialogView) {
        mDialogView = dialogView;
        mDialogView.show(getSupportFragmentManager());
    }

    @Override
    public void hideDialog() {
        if (mDialogView != null) {
            mDialogView.dismissDialog();
        }
    }

    @Override
    public BaseDialogView getDialogInstance() {
        return mDialogView;
    }
    
    @Override
    public void hideKeyBoard(View v) {
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        if (in != null) {
            in.hideSoftInputFromWindow(v.getWindowToken(),

                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    @Override
    public boolean checkAppPermission(String[] reqPermissions) {
        for (String permission : reqPermissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public boolean checkPreviouslyDenied(String[] reqPermissions) {
        for (String permission : reqPermissions) {
            if (shouldShowRequestPermissionRationale(permission)) {
                return true;
            }
        }

        return false;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void showSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    public void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        TextView textView = sbView
                .findViewById(R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }
    public AppPreferenceHelperClass getAppPreferenceHelperClass(){
        return appPreferenceHelperClass;
    }
}
