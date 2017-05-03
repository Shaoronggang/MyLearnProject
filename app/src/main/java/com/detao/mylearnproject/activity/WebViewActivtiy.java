package com.detao.mylearnproject.activity;

import android.content.Intent;
import android.webkit.WebView;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;

import butterknife.BindView;

import static com.detao.mylearnproject.util.AppUtils.webViewTest;

/**
 * Created by shaoronggang on 2017/5/2.
 */

public class WebViewActivtiy extends BaseActivity {
    @BindView(R.id.web_activity)
    WebView webView;

    @Override
    protected int getResLayout() {
        return R.layout.webview_layout;
    }

    @Override
    public void afterView() {
        super.afterView();
        Intent intent = getIntent();
        String url1  = intent.getStringExtra("url");
        webViewTest(url1,webView);
    }
}
