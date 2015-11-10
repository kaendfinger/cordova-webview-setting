package com.darktalker.cordova.webviewsetting;

import org.json.JSONArray;
import org.json.JSONException;

import org.apache.cordova.engine.*;
import org.apache.cordova.*;

import android.os.Build;
import android.webkit.WebView;

import android.util.Log;

public class WebviewSetting extends CordovaPlugin {
    @Override
    public void initialize(final CordovaInterface cordova, CordovaWebView wv) {
        super.initialize(cordova, wv);
        CordovaWebViewImpl webViewImpl = (CordovaWebViewImpl) wv;
        SystemWebViewEngine engine = (SystemWebViewEngine) webViewImpl.getEngine();
        WebView webView = (WebView) engine.getView();
        webView.setInitialScale(1);
        Log.i("Cordova", "Using Wide ViewPort");
        webView.getSettings().setUserAgentString("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2227.0 Safari/537.36");
        //webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }
}
