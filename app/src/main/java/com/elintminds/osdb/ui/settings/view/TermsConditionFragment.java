package com.elintminds.osdb.ui.settings.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;

public class TermsConditionFragment extends BaseFragment {


    public static String TAG="Terms & Conditions";
    public static TermsConditionFragment newInstance() {
        return new TermsConditionFragment();
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


            }
        });

        webView.loadUrl("https://staging.osdb.pro");
    }



}
