package com.darktalker.cordova.webviewsetting;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import android.os.Build;

import android.util.Log;



public class WebviewSetting extends CordovaPlugin {
    private CordovaWebView wv;
    private static final String LOG_TAG = "WebviewSetting";
    @Override
    public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
        this.wv = webView;
        super.initialize(cordova, webView); 
        
    }
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if ("set".equals(action)) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
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
                    
                    callbackContext.success();
                }
            });
            return true;
        }
        return false;  // Returning false results in a "MethodNotFound" error.
    }
}
