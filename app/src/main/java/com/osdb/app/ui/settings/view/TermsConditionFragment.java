package com.osdb.app.ui.settings.view;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.osdb.app.R;
import com.osdb.app.ui.base.view.BaseFragment;

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
        setUpLinks(view);
//        WebView webView = view.findViewById(R.id.webview);
//        webView.getSettings().setLoadsImagesAutomatically(true);
//        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//        webView.getSettings().setJavaScriptEnabled(true);
//
//        Bundle bundle = getArguments();
//        if (bundle != null) {
//            String url = bundle.getString("url");
//            showProgressDialog();
//
//            webView.setWebViewClient(new WebViewClient() {
//                public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                    Log.i("tag", "Processing webview url click...");
//                    view.loadUrl(url);
//                    return true;
//                }
//
//                public void onPageFinished(WebView view, String url) {
//
//                    hideProgressDialog();
//                }
//
//                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//                    hideProgressDialog();
//
//                }
//            });
//
//            webView.loadUrl("http://docs.google.com/gview?embedded=true&url="
//                    + "https://drive.google.com/open?id=1mG5lwwv-FW9rRFGqwBoEczop6skhQCpZ");
//        } else {
//            Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
//            getActivity().onBackPressed();
//        }
    }

    private void setUpLinks(View view) {
        Bundle bundle = getArguments();

        if (bundle != null) {
            String url = bundle.getString("url");
            showProgressDialog();
            WebView webView = view.findViewById(R.id.webview);
      
            webView.setWebViewClient(new AppWebViewClients());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setLoadsImagesAutomatically(true);
            webView.getSettings().setAllowFileAccessFromFileURLs(true);
            webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
            webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
            webView.setScrollbarFadingEnabled(false);
            webView.setVerticalScrollBarEnabled(true);
            webView.setHorizontalScrollBarEnabled(true);
            webView.getSettings().setAppCacheEnabled(false);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setDisplayZoomControls(false);
            webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setDomStorageEnabled(true);
            webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

            //  webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            if (Build.VERSION.SDK_INT >= 19) {
                webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
            else {
                webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            }
            webView.loadUrl(url);
            hideProgressDialog();
//        webView.loadUrl("https://drive.google.com/open?id=1mG5lwwv-FW9rRFGqwBoEczop6skhQCpZ");
        }

    }

    public class AppWebViewClients extends WebViewClient {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            hideProgressDialog();
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

        }
    }

}
