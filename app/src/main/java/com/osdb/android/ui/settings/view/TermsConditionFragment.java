package com.osdb.android.ui.settings.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.osdb.android.R;
import com.osdb.android.ui.base.view.BaseFragment;

public class TermsConditionFragment extends BaseFragment {


    public static String TAG = "Terms & Conditions";

    public static TermsConditionFragment newInstance(String url) {
        TermsConditionFragment termsConditionFragment = new TermsConditionFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        termsConditionFragment.setArguments(bundle);
        return termsConditionFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.terms_fragment_view, container, false);
    }

    @Override
    protected void setUp(View view) {

        WebView webView = view.findViewById(R.id.webview);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.getSettings().setJavaScriptEnabled(true);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String url = bundle.getString("url");
            showProgressDialog();

            webView.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    Log.i("tag", "Processing webview url click...");
                    view.loadUrl(url);
                    return true;
                }

                public void onPageFinished(WebView view, String url) {

                    hideProgressDialog();
                }

                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    hideProgressDialog();

                }
            });

            webView.loadUrl(url);
        } else {
            Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
            getActivity().onBackPressed();
        }
    }


}
