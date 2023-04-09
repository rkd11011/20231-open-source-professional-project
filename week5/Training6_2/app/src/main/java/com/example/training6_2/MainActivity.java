package com.example.training6_2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    EditText edtUrl; //URL 입력란
    Button btnGo, btnBack; // 이동, 뒤로가기 버튼
    WebView web; // 웹뷰

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //엑션바 로고 이미지 설정
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.images2);

        
        //XML 레이아웃 파일에서 각뷰 객체 참조
        edtUrl = (EditText) findViewById(R.id.edtUrl);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        web = (WebView) findViewById(R.id.webView1);

        //WebViewClient 설정
        web.setWebViewClient(new CookWebViewClient());
        
        //웹뷰 설정
        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true);// 줌 제어 사용
        webSet.setJavaScriptEnabled(true);// 자바스크립트 사용

        //이동 버튼 클릭시 URL로딩
        btnGo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web.loadUrl(edtUrl.getText().toString());
            }
        });
    
        // 뒤로가기 버튼 클릭시 이전 페이지로 이동
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web.goBack();
            }
        });

    }

    // WebViewClient 클래스 정의
    class CookWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

}
