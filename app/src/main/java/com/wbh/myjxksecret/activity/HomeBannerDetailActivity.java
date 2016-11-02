package com.wbh.myjxksecret.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.utils.MyShareSDK;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeBannerDetailActivity extends AppCompatActivity {

    @BindView(R.id.iv_banner_back)
    ImageView iv_banner_back;
    @BindView(R.id.tv_home_bannerTitle)
    TextView tv_home_bannerTitle;
    @BindView(R.id.iv_banner_share)
    ImageView iv_banner_share;
    @BindView(R.id.webView_banner)
    WebView webView_banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_banner_detail);
        ButterKnife.bind(this);
        initWebView();
    }

    //点击返回上一界面
    @OnClick(R.id.iv_banner_back)
    public void backActivity(View view) {
        finish();
    }

    //点击分享
    @OnClick(R.id.iv_banner_share)
    public void share(View view) {
        MyShareSDK.showShare(this);
    }

    //操作WebView
    private void initWebView() {
        Intent intent = getIntent();
        String goValue = intent.getStringExtra("goValue");
        String title = intent.getStringExtra("title");
        tv_home_bannerTitle.setText(title);
        webView_banner.loadUrl(goValue);



        WebSettings settings = webView_banner.getSettings();
        //支持js 语言
        settings.setJavaScriptEnabled(true);
        //插件
        webView_banner.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                //progress:0-100
            }
        });
    }
}
