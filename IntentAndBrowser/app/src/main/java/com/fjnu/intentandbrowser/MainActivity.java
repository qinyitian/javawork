package com.fjnu.intentandbrowser;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

import edu.fjnu.cse.mybrowser.R;

public class MainActivity extends AppCompatActivity {
    boolean isLoadUrl = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_browser);

        Intent intent = getIntent();

        Uri data = intent.getData();
        URL url = null;

        try{
            url = new URL(data.getScheme(),data.getHost(),data.getPath());
        }catch (Exception e){
            e.printStackTrace();
        }

        startBrowser(url);
    }

    private void startBrowser(URL url) {
        WebView webView = (WebView) findViewById(R.id.webView);
        //WebView加载web资源
        webView.loadUrl(url.toString());
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient(){


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                if(!isLoadUrl) {
                    isLoadUrl = true;
                    view.loadUrl(url);
                }
                return true;
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                if(!isLoadUrl){
                    isLoadUrl = true;
                    view.loadUrl(url);
                }
                super.onPageStarted(view, url, favicon);
            }
        });
    }
}
