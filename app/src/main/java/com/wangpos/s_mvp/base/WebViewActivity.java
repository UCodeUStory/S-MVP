package com.wangpos.s_mvp.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.wangpos.s_mvp.R;


/**
 * @ Author: qiyue (ustory)
 * @ Email: qiyuekoon@foxmail.com
 * @ Data:2016/3/11
 */
public class WebViewActivity extends Activity {

    private WebView webview;
    private static final int PROGRESS_RATIO = 1000;
    public final static String EXTRA_URL = "toUrl";
    private ProgressBar webviewPb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webview = (WebView) findViewById(R.id.webview);
        webviewPb = (ProgressBar) findViewById(R.id.webview_pb);
        setWindowStatusBarColor(this,R.color.github_title);
        initCreateData();
    }



    public static void setWindowStatusBarColor(Activity activity, int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(activity.getResources().getColor(colorResId));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void enableCustomClients() {
        this.webview.setWebViewClient(new DemoWebViewClient());
        this.webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                WebViewActivity.this.webviewPb.setProgress(progress);
                setProgress(progress * PROGRESS_RATIO);
                if (progress >= 80) {
//                    WebViewActivity.this.webviewPb.setVisibility(View.GONE);
                } else {
                    WebViewActivity.this.webviewPb.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    class DemoWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("http:") || url.startsWith("https:")) {
                return false;
            }
            return true;
        }
    }

    protected void initCreateData() {
        this.enableCustomClients();

        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        webview.getSettings().setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        webview.getSettings().setSupportZoom(true);//是否可以缩放，默认true
        webview.getSettings().setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        webview.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        webview.getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        webview.getSettings().setAppCacheEnabled(true);//是否使用缓存
        webview.getSettings().setDomStorageEnabled(true);//DOM Storage
        webview.getSettings().setTextSize(WebSettings.TextSize.NORMAL);

        this.webview.loadUrl(this.getUrl());
    }


    private String getUrl() {
        // return IntentUtils.getStringExtra(this.getIntent(), EXTRA_URL);
        return this.getIntent().getStringExtra(EXTRA_URL);
        // return "http://www.jianshu.com/c/5139d555c94d";
    }

    public static void toUrl(Context context, String url) {
        toUrl(context, url, android.R.string.untitled);
    }

    /**
     * @param context    Any context
     * @param url        A valid url to navigate to
     * @param titleResId A String resource to display as the title
     */
    public static void toUrl(Context context, String url, int titleResId) {
        toUrl(context, url, context.getString(titleResId));
    }

    /**
     * @param context Any context
     * @param url     A valid url to navigate to
     * @param title   A title to display
     */
    public static void toUrl(Context context, String url, String title) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(EXTRA_URL, url);
        context.startActivity(intent);
    }

    /**
     * @param context context
     * @param url     url
     * @param title   title
     * @param type    type
     */
    public static void toUrl(Context context, String url, String title, String type) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(EXTRA_URL, url);
        context.startActivity(intent);
    }


}
