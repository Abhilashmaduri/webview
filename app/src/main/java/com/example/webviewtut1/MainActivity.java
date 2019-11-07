package com.example.webviewtut1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressbar);
        toolbar=findViewById(R.id.Toolbar);
        setWebView();
    }

    private void setWebView()
    {
        webView=findViewById(R.id.webview);
        webView.loadUrl("https://www.google.com/");
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

                webView.setWebViewClient(new WebViewClient()
                {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

              String url=request.getUrl().toString();
              webView.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

        });
               setChromeWebClient();
    }

    private void setChromeWebClient()
    {

        webView.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                toolbar.setTitle(title);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }

        });
    }
}
