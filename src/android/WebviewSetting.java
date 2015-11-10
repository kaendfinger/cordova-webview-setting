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
        //webView.getSettings().setLoadWithOverviewMode(true);
        //webView.getSettings().setUseWideViewPort(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }
}
